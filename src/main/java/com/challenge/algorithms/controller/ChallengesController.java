package com.challenge.algorithms.controller;

import com.challenge.algorithms.model.RequestString;
import com.challenge.algorithms.model.RequestTicTacToe;
import com.challenge.algorithms.service.IChallenges;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChallengesController {

    @Autowired
    private IChallenges challenges;
    private final Logger log = LoggerFactory.getLogger(ChallengesController.class);
    /**
     * Title: Alphanumeric String Sort
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
    @PostMapping("/string-order")
    public ResponseEntity<?> alphanumericStringSort(@RequestBody RequestString requestString){
        log.info("log: {}", requestString.getInputString());
        return ResponseEntity.ok(challenges.stringOrderChallenge(requestString));
    }

    /**
     * Challenge name: balanced-parentheses
     * Description:
     * Given a string that may contain parentheses validate if it has all being and ending parentheses
     * Examples:
     *  input:   (hello, world)
     *  output: valid
     *  input:   Random text (as this) is ok().
     *  output: valid
     *  input:   )(
     *  output: invalid
     * @param requestString
     * @return
     */
    @RequestMapping("/balanced-parentheses")
    public ResponseEntity<?> balancedParentheses(@RequestBody RequestString requestString){
        log.info("Input String: {}", requestString.getInputString());
        return ResponseEntity.ok(challenges.balancedParentheses(requestString));
    }

    /**
     * Challenge name: Find Winner on a Tic Tac Toe Game
     * Description: Tic-tac-toe is played by two players A and B on a 3 x 3 grid.
     * In this Tic-Tac-Toe challenge, you are given a 3 x 3 grid representing the game board. Two players, A and B, take turns placing their respective characters ('X' and 'O') into empty squares of the grid.
     * The game continues until there are three of the same characters in a row, column, or diagonal, resulting in a win for the player with the matching characters.
     * If all squares are filled without any player achieving a winning combination, the game ends in a draw.
     * Additionally, if there are still empty squares on the grid and no winner has been determined, the game is considered to be ongoing (pending).
     * You can assume that 'moves' array is valid (i.e., it follows the rules of Tic-Tac-Toe), the grid is initially empty, and A will play first.
     * @param moves
     * @return
     */
    @RequestMapping("/tic-tac-toe")
    public ResponseEntity<?> ticTacToeGame(@RequestBody RequestTicTacToe moves){
        log.info("Input Moves: {}", moves.toString());
        return ResponseEntity.ok(challenges.ticTacToeChallenge(moves));
    }
}
