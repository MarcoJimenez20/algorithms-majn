package com.challenge.algorithms.controller;

import com.challenge.algorithms.model.RequestStringSort;
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
     * @param requestStringSort
     * @return
     */
    @PostMapping("/string-order")
    public ResponseEntity<?> alphanumericStringSort(@RequestBody RequestStringSort requestStringSort){
        log.info("log: {}",requestStringSort.getAlphanumericString());
        return ResponseEntity.ok(challenges.stringOrderChallenge(requestStringSort));
    }

}
