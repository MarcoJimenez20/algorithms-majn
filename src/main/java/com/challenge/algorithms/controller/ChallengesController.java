package com.challenge.algorithms.controller;

import com.challenge.algorithms.model.RequestString;
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
}
