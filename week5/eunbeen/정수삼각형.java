import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;

        int length = triangle.length;

        int[][] dp = new int[length][length];
        dp[0][0] = triangle[0][0];
        dp[1][0] = dp[0][0] + triangle[1][0];
        dp[1][1] = dp[0][0] + triangle[1][1];
        
        for(int i=2; i<length; i++){
            dp[i][0] = triangle[i][0] + dp[i-1][0];
            for(int j=1; j<i; j++){
                dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
            }
            dp[i][i] = triangle[i][i] + dp[i-1][i-1];
        }
        
        for(int item : dp[length-1]){
            answer = Math.max(item, answer);
        }
        
        return answer;
    }
}


/*
7
3 8
8 1 0
2 7 4 4 
4 5 2 6 5



*/