import java.util.*;
class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int n = money.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        
        if(n < 2){
            for(int i=0; i<n; i++){
                answer = Math.max(answer, money[i]);
            }
            return answer;
        }
        
        //도둑질 했을 경우
        dp1[0] = money[0];
        dp1[1] = money[0];
        
        for(int i=2; i<n-1; i++){
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + money[i]);
        }
        
        //도둑질 X 경우
        dp2[1] = money[1];
        
        for(int i=2; i<n; i++){
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + money[i]);
        }
        
        
        return Math.max(dp1[n-2], dp2[n-1]);
    }
}

/*

인접한 두 집을 털면 경보가 울림
모든 집들은 동그랗게 배치되어 있음

도둑이 훔칠 수 있는 돈의 최댓값

1 0 0 0
1 2 0 0
1 2 4 0
1 2 4 3

0 0 0 0
0 3 0 0
0 3 4 0
0 3 4 1


*/