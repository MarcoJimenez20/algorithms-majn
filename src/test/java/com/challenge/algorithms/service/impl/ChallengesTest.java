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
    void stringOrderChallenge() {
        RequestString requestString = new RequestString();
        requestString.setInputString("vrlfaaA?4320%#");
        assertNotNull(challenges.stringOrderChallenge(requestString));
    }
}