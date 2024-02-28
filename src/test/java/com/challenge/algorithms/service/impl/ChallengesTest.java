package com.challenge.algorithms.service.impl;

import com.challenge.algorithms.model.RequestStringSort;
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
        RequestStringSort requestStringSort = new RequestStringSort();
        requestStringSort.setAlphanumericString("vrlfaaA?4320%#");
        assertNotNull(challenges.stringOrderChallenge(requestStringSort));
    }
}