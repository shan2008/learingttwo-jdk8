package com.yous.learningtwo.host.algorithm;

public class PrintMatrix {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix[0].length <= 0) {
            return new int[0];
        }
        int[][] visited = new int[matrix.length][matrix[0].length];
        int row = matrix.length;
        int column = matrix[0].length;

        int total = matrix.length * matrix[0].length;
        int r = 0, c = 0;
        int[] result = new int[total];
        for (int i = 0; i < total; i++) {
            while (c < column ) {
                result[i] = matrix[r][c];
                i++;
                visited[r][c]=1;
                if(visited[r][c+1] == 1){
                    break;
                }
                c++;
            }
            while (r < row) {
                result[i] = matrix[r][c];
                visited[r][c] = 1;
                i++;
                if(visited[r+1][c]==1){
                    break;
                }
                r++;
            }

            // 列-
            while (c >= 0) {
                result[i] = matrix[r][c];
                visited[r][c] = 1;
                i++;
                if (visited[r][c - 1] == 1) {
                    break;
                }
                c--;
            }

            // 行--
            while (r >= 0) {
                result[i] = matrix[r][c];
                visited[r][c] = 1;
                i++;
                if (visited[r - 1][c] == 1) {
                    break;
                }
                r--;
            }
        }

        return result;
    }


}
