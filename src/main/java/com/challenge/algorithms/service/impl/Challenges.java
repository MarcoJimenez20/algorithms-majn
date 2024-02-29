package com.challenge.algorithms.service.impl;

import com.challenge.algorithms.model.RequestString;
import com.challenge.algorithms.model.RequestTicTacToe;
import com.challenge.algorithms.model.ResponseAlgorithms;
import com.challenge.algorithms.service.IChallenges;
import com.challenge.algorithms.utils.Constansts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class Challenges implements IChallenges{

    private final Logger log = LoggerFactory.getLogger(Challenges.class);

    /**
     * Description:
     * Taking a string as input sort the string characters with the following rules:
     * - Numbers go after Letters
     * - Uppercase letters go after Lowercase
     * - Odd numbers go before Even numbers
     * - Any character that is not a letter or number should go after the letters and numbers
     * i.e.: abeCD4®
     * @param requestString
     * @return
     */
    @Override
    public ResponseAlgorithms stringOrderChallenge(RequestString requestString) {
        log.debug("Alphanumeric String Input: {}", requestString.getInputString());
        ResponseAlgorithms response = new ResponseAlgorithms();
        response.setName("Alphanumeric String Sort");
        //String prueba = "40%var#23Alfa";
        String alphanumericStringSorted = requestString.getInputString().chars()
                .mapToObj(c -> (char) c)
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining());

        Map<String, String> answer = new HashMap<>();
        answer.put("alphanumeric-string-sorted", alphanumericStringSorted);
        answer.put("alphanumeric-string-input", requestString.getInputString());
        response.setAnswer(answer);

        return response;
    }

    /**
     * Challenge name: balanced-parentheses
     *  Description:
     * Given a string that may contain parentheses validate if it has all being and ending parentheses
     * Examples:
     *  input:   (hello, world)
     *  output: valid
     *  input:   Random text (as this) is ok().
     *  output: valid
     *  input:   )(
     *  output: invalid
     * @param input
     * @return
     */
    @Override
    public ResponseAlgorithms balancedParentheses(RequestString input) {
        ResponseAlgorithms responseBalancedParentheses = new ResponseAlgorithms();
        responseBalancedParentheses.setName("Balanced Parentheses");

        Boolean valid = balancedString(input);
        log.info("Es valido?: {}", valid.toString());
        Map<String, String> answer = new HashMap<>();
        answer.put("output", valid ? "valid": "invalid");
        answer.put("input", input.getInputString());
        responseBalancedParentheses.setAnswer(answer);
        return responseBalancedParentheses;
    }

    /**
     * Challenge name: Find Winner on a Tic Tac Toe Game
     * Description: Tic-tac-toe is played by two players A and B on a 3 x 3 grid.
     * In this Tic-Tac-Toe challenge, you are given a 3 x 3 grid representing the game board.
     * Two players, A and B, take turns placing their respective characters ('X' and 'O') into empty squares of the grid.
     * Constraints:
     *      1 <= moves.length <= 9
     *      moves[i].length == 2
     *      0 <= row[i], col[i] <= 2
     *      There are no repeated elements on 'moves'.
     *      'moves' follow the rules of tic-tac-toe.
     * Your task is to implement a function/method that takes the 3 x 3 array as input and returns the winner of the game (A or B)
     * if there is one, or "Draw" if the game ends in a draw, or "Pending" if the game is still ongoing.
     * Your implementation should also include the necessary unit test cases to verify the correctness of your solution.
     * @param moves
     * @return
     */

    @Override
    public ResponseAlgorithms ticTacToeChallenge(RequestTicTacToe moves) {
        ResponseAlgorithms ticTacToeResponse = new ResponseAlgorithms();
        ticTacToeResponse.setName("Tic Tac Toe Game");

        Boolean valid = validateMoves(moves);
        log.info("Validation result: {}", valid.toString());

        Map<String, String> answer = new HashMap<>();
        answer.put("output", gameLogic(moves));
        answer.put("input", "moves = "+Arrays.deepToString(moves.getMoves()));
        ticTacToeResponse.setAnswer(answer);

        return ticTacToeResponse;
    }

    public Boolean balancedString(RequestString optionalInput){
        int bandera = 0;
        if (Objects.isNull(optionalInput.getInputString())
                || optionalInput.getInputString().trim().isEmpty()) {
            return false;
        }

        for (char c : optionalInput.getInputString().toCharArray()) {
            if (c == '(') {
                bandera++;
            } else if (c == ')') {
                bandera--;
                if (bandera < 0) {
                    return false;
                }
            }
        }

        return bandera == 0;
    }
    public Boolean validateMoves(RequestTicTacToe moves){
        Set<String> uniqueMoves = new HashSet<>();
        if (Objects.isNull(moves)
                || Objects.isNull(moves.getMoves())
                || Arrays.stream(moves.getMoves()).anyMatch(move -> move == null)
                || moves.getMoves().length == 0
                || moves.getMoves().length < 1
                || moves.getMoves().length > 9
                || Arrays.stream(moves.getMoves()).anyMatch(move -> move.length != 2)
                || !Arrays.stream(moves.getMoves()).map(Arrays::toString).allMatch(uniqueMoves::add)) {
            return false;
        }
        return true;
    }

    public String gameLogic(RequestTicTacToe moves){
        int[][] playersMoves = moves.getMoves();
        int[][] playerA = IntStream.range(0, playersMoves.length).filter(i -> i % 2 == 0)
                .mapToObj(i -> playersMoves[i]).toArray(int[][]::new);

        log.info("Moves from player A: ");
        Arrays.stream(playerA).forEach(move->log.info(Arrays.toString(move)));

        int[][] playerB = IntStream.range(0, playersMoves.length).filter(i -> i % 2 != 0)
                .mapToObj(i -> playersMoves[i]).toArray(int[][]::new);

        log.info("Moves from player B: ");
        Arrays.stream(playerB).forEach(move->log.info(Arrays.toString(move)));

        String[] movesPlayerA = playersMoves(playerA);
        String[] movesPlayerB = playersMoves(playerB);
        Set<String> setPlayerA = new HashSet<>(Arrays.asList(movesPlayerA));
        Set<String> setPlayerB = new HashSet<>(Arrays.asList(movesPlayerB));

        Boolean resultA = Constansts.winingCombinationsList.stream()
                .anyMatch(arr -> new HashSet<>(Arrays.asList(arr)).equals(setPlayerA));
        Boolean resultB = Constansts.winingCombinationsList.stream()
                .anyMatch(arr -> new HashSet<>(Arrays.asList(arr)).equals(setPlayerB));

        log.info("A result: {}",resultA);
        log.info("B result: {}", resultB);

        return getGameResult(resultA,resultB);
    }
    public String getGameResult(Boolean playerA, Boolean playerB){
        if(!playerA && !playerB){
            return "Draw";
        }
        if(playerA){
            return "A";
        }else if(playerB){
            return "B";
        }
        return "wrong input";
    }

    public String[] playersMoves(int[][] playerMoves){
        return  Arrays.stream(playerMoves).map(move -> Arrays.stream(move)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining()))
                .toArray(String[]::new);
    }
}
