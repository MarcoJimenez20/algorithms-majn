package com.challenge.algorithms.utils;

import java.util.Arrays;
import java.util.List;

public class Constansts {

    public static final String[] row0WinningCombination = {"00","01","02"};
    public static final String[] row1WinningCombination = {"10","11","12"};
    public static final String[] row2WinningCombination = {"20","21","22"};

    public static final String[] column0WinningCombination = {"00","10","20"};
    public static final String[] column1WinningCombination = {"01","11","21"};
    public static final String[] column2WinningCombination = {"02","12","22"};

    public static final String[] diagonalWinningCombination1 = {"00","11","22"};
    public static final String[] diagonalWinningCombination2 = {"20","11","02"};

    public static final List<String[]> winingCombinationsList = Arrays.asList(row0WinningCombination,row1WinningCombination,row2WinningCombination
    ,column0WinningCombination,column1WinningCombination,column2WinningCombination,diagonalWinningCombination1,diagonalWinningCombination2);

}
