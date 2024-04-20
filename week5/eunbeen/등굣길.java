import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] dp = new int[n][m];
        
        dp[0][0] = 0;
        for(int i=1; i<m; i++){
            dp[0][i] = dp[0][i-1] + 1;
        }
        
        for(var puddle : puddles){
            if(puddle.length == 0) break;
            dp[puddle[1]-1][puddle[0]-1] = -1;
        }
        
        for(int i=1; i<n; i++){
            dp[i][0] = (dp[i][0] == -1 || dp[i-1][0] == -1) ? -1 : 1;
        }
        
        for(int i=1; i<m; i++){
            dp[0][i] = (dp[0][i] == -1 || dp[0][i-1] == -1) ? -1 : 1;
        }
        
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(dp[i][j] == -1) continue;
                
                int left = dp[i-1][j] == -1 ? 0 : dp[i-1][j]%1000000007;
                int up = dp[i][j-1] == -1 ? 0 : dp[i][j-1]%1000000007;
                
                dp[i][j] = (left+up) == 0 ? -1 : (left+up)%1000000007;
            }
        }
        
        for(var item :  dp){
            System.out.println(Arrays.toString(item));
        }
        
        return dp[n-1][m-1] == -1 ? 0 : dp[n-1][m-1];
    }
}



/*

print(solution(2, 2, []), 2)
print(solution(3, 3, []), 6)
print(solution(3, 3, [[2, 2]]), 2)
print(solution(3, 3, [[2, 3]]), 3)
print(solution(3, 3, [[1, 3]]), 5)
print(solution(3, 3, [[1, 3], [3, 1]]), 4)
print(solution(3, 3, [[1, 3], [3, 1], [2, 3]]), 2)
print(solution(3, 3, [[1, 3], [3, 1], [2, 3], [2, 1]]), 1)
print(solution(7, 4, [[2, 1], [2, 2], [2, 3], [4, 2], [4, 3], [4, 4], [6, 2], [6, 3]]), 0) // 이 값이 잘 나오면 테스트1, 테스트9 통과, 위로 가면 안됨
print(solution(4, 4, [[3, 2], [2, 4]]), 7)
print(solution(100, 100, []), 690285631)


*/