# Santander algorithm challenges
This repository contains a spring boot project. You will find the challenge algorithms from the Santander account.
The framework of the project is spring boot and it uses the java version 17. It is use the starter web dependency in order to take advantage of a web application.
domain: localhost
port: 8080

Challenge:
1.- Alphanumeric String Sort
  endpoint: /string-order
  method: POST
  payload: {"inputString":"null"}
  
  Description:
    The first challenge is taking a string as input and sort the string characters with the following rules:
    Numbers go after Letters
    Uppercase letters go after Lowercase
    Odd numbers go before Even numbers
    Any character that is not a letter or number should go after the letters and numbers.

2.- Balanced-Parentheses
    endpoint: /balanced-parentheses
    payload: {"inputString":"null"}
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