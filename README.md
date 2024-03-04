# Santander algorithm challenges
This repository contains a spring boot project. You will find the challenge algorithms from the Santander account.
The framework of the project is spring boot and it uses the java version 17. It is use the starter web dependency in order to take advantage of a web application.
domain: localhost
port: 8080


1.- Challenge name: Alphanumeric String Sort
  endpoint: /string-order
  method: POST
  payload: {"inputString": <String>}
  
  Description:
    The first challenge is taking a string as input and sort the string characters with the following rules:
    Numbers go after Letters
    Uppercase letters go after Lowercase
    Odd numbers go before Even numbers
    Any character that is not a letter or number should go after the letters and numbers.

2.- Challenge name: Balanced-Parentheses
    endpoint: /balanced-parentheses
    payload: {"inputString": <String>}
    Description:
    Given a string that may contain parentheses validate if it has all being and ending parentheses
    Examples:
        input:   ()
        output: valid
        input:  (hello, world)
        output: valid
        input:   )()(
        output: invalid
        input:   ())(()
        output: invalid

3.- Challenge name: Find Winner on a Tic Tac Toe Game
   endpoint: /tic-tac-toe
   payload: {"moves": <int[][]>}

   Description: Tic-tac-toe is played by two players A and B on a 3 x 3 grid.
   In this Tic-Tac-Toe challenge, you are given a 3 x 3 grid representing the game board. Two players, A and B, take turns placing their respective characters ('X' and 'O') into empty squares of the grid.
   The game continues until there are three of the same characters in a row, column, or diagonal, resulting in a win for the player with the matching characters.
   If all squares are filled without any player achieving a winning combination, the game ends in a draw.
   Additionally, if there are still empty squares on the grid and no winner has been determined, the game is considered to be ongoing (pending).
   You can assume that 'moves' array is valid (i.e., it follows the rules of Tic-Tac-Toe), the grid is initially empty, and A will play first.
   Constraints:
   1 <= moves.length <= 9
   moves[i].length == 2
   0 <= row[i], col[i] <= 2
   There are no repeated elements on 'moves'.
   'moves' follow the rules of tic tac toe.
   Your task is to implement a function/method that takes the 3 x 3 array as input and returns the winner of the game (A or B) if there is one, or "Draw" if the game ends in a draw, or "Pending" if the game is still ongoing.
   Your implementation should also include the necessary unit test cases to verify the correctness of your solution.
   
4.- Challenge name: Pascal’s Triangle
    endpoint: /pascals-triangle/{rows}
    rows = row calculation for pascal's triangle 
    Description: Given numRows, generate the first numRows of Pascal’s triangle. For example, given numRows = 5, the result should be:
    [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]