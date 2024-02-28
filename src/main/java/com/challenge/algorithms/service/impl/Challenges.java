package com.challenge.algorithms.service.impl;

import com.challenge.algorithms.model.RequestString;
import com.challenge.algorithms.model.ResponseAlgorithms;
import com.challenge.algorithms.service.IChallenges;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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

    public Boolean balancedString(RequestString optionalInput){
        int bandera = 0;
        if (Objects.isNull(optionalInput.getInputString())
                || optionalInput.getInputString().trim().isEmpty()
                || !optionalInput.getInputString().contains("()")) {
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
}
