package com.challenge.algorithms.service.impl;

import com.challenge.algorithms.model.RequestStringSort;
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
     * @param requestStringSort
     * @return
     */
    @Override
    public ResponseAlgorithms stringOrderChallenge(RequestStringSort requestStringSort) {
        log.debug("Alphanumeric String Input: {}",requestStringSort.getAlphanumericString());
        ResponseAlgorithms response = new ResponseAlgorithms();
        response.setName("Alphanumeric String Sort");
        //String prueba = "40%var#23Alfa";
        String alphanumericStringSorted = requestStringSort.getAlphanumericString().chars()
                .mapToObj(c -> (char) c)
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining());

        Map<String, String> answer = new HashMap<>();
        answer.put("alphanumeric-string-sorted", alphanumericStringSorted);
        answer.put("alphanumeric-string-input", requestStringSort.getAlphanumericString());
        response.setAnswer(answer);

        return response;
    }
}
