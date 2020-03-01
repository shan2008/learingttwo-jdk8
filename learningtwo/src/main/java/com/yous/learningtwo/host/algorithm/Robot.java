package com.yous.learningtwo.host.algorithm;

public class Robot {

    public int movingCount(int m, int n, int k) {
        int isVisited[][] = new int[m][n];
        return moveCount(0,0,k,isVisited);
    }



    public int moveCount(int i,int j,int k,int[][]isVisited){
        int row=isVisited.length;
        int col=isVisited[0].length;
        int count=0;
        if(i>=0 && i<col && j>=0 && j<row && (isVisited[i][j]==0)&& smallThanEqualK(i,j,k)){
            count = 1 + moveCount(i - 1, j, k, isVisited)
                    + moveCount(i, j - 1, k, isVisited) + moveCount(i + 1, j, k, isVisited)
                    + moveCount(i, j + 1, k, isVisited);

        }

        return count;
    }



    public boolean smallThanEqualK(int i,int j,int k){
        int sum=0;
        while(i>0){
            sum+=i%10;
            i=i/10;
        }

        while(j>0){
            sum+=j%10;
            j=j/10;
        }
        return sum<=k;
    }

}
