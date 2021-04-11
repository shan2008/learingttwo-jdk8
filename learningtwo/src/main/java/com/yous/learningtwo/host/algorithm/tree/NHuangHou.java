package com.yous.learningtwo.host.algorithm.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NHuangHou {
    /**
     * N 皇后
     *
     * @param n
     * @return
     */


    @Test
    public void test(){
        List<List<String>> listList = solveNQueens(4);

        listList.forEach(x->System.out.println(x));
        System.out.println(listList.size());
    }


    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] chess = new char[n][n];
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[i].length; j++) {
                chess[i][j] = '.';
            }
        }

        slove(chess, 0, result);
        return result;
    }


    public void slove(char[][] chess, int row, List<List<String>> result) {
        if (row == chess.length) {
            result.add(mapResult(chess));
            return ;
        }
        for (int col = 0; col < chess.length; col++) {
            if (!valid(chess, row, col)) {
                continue;
            }
            chess[row][col] = 'Q';
            slove(chess, row + 1, result);
            chess[row][col] = '.';
        }
    }


    public List<String> mapResult(char[][] chess) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < chess.length; i++) {
            result.add(new String(chess[i]));
        }
        return result;
    }

    public boolean valid(char[][] chess, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (chess[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length ; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}

