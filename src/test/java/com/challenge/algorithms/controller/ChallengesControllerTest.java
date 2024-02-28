package com.challenge.algorithms.controller;

import com.challenge.algorithms.model.RequestString;
import com.challenge.algorithms.model.ResponseAlgorithms;
import com.challenge.algorithms.service.IChallenges;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class ChallengesControllerTest {

    @InjectMocks
    private ChallengesController challengesController;

    @Mock
    private IChallenges challenges;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(challengesController).build();
    }
    @Test
    void alphanumericStringSort() throws Exception {
        RequestString requestMock = new RequestString();

        requestMock.setInputString("abcd4");
        Mockito.when(challenges.stringOrderChallenge(requestMock)).thenReturn(new ResponseAlgorithms());
        ResponseEntity<ResponseAlgorithms> responseEntity = new ResponseEntity<>(new ResponseAlgorithms(),HttpStatus.OK);
        assertNotNull(challengesController.alphanumericStringSort(requestMock));
    }
}