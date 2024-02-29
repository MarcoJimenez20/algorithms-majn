package com.challenge.algorithms.service.impl;

import com.challenge.algorithms.model.RequestString;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ChallengesTest {

    @InjectMocks
    private Challenges challenges;

    @Test
    void stringOrderChallengeTest() {
        RequestString requestString = new RequestString();
        requestString.setInputString("vrlfaaA?4320%#");
        assertNotNull(challenges.stringOrderChallenge(requestString));
    }
    @Test
    void balancedParenthesesTest(){
        RequestString requestString = new RequestString();
        requestString.setInputString("a(");
        assertNotNull(challenges.balancedParentheses(requestString));
    }
    @Test
    void balancedParenthesesNullTest(){
        RequestString requestString = new RequestString();
        requestString.setInputString(null);
        assertNotNull(challenges.balancedParentheses(requestString));
    }
    @Test
    void balancedParenthesesEmptyTest(){
        RequestString requestString = new RequestString();
        requestString.setInputString(" ");
        assertNotNull(challenges.balancedParentheses(requestString));
    }
    @Test
    void balancedParenthesesValidTest(){
        RequestString requestString = new RequestString();
        requestString.setInputString("(Hello (,) world (!))");
        assertNotNull(challenges.balancedParentheses(requestString));
    }

    @Test
    void balancedParenthesesInvalidTest(){
        RequestString requestString = new RequestString();
        requestString.setInputString("())(()");
        assertNotNull(challenges.balancedParentheses(requestString));
    }
}