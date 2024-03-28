package com.challenge.algorithms.service;

import com.challenge.algorithms.model.RequestString;
import com.challenge.algorithms.model.RequestTicTacToe;
import com.challenge.algorithms.model.ResponseAlgorithms;

public interface IChallenges {

    ResponseAlgorithms stringOrderChallenge(RequestString input);

    ResponseAlgorithms balancedParentheses(RequestString input);

    ResponseAlgorithms ticTacToeChallenge(RequestTicTacToe moves);

    ResponseAlgorithms pascalsTriangle(int rows);
}
