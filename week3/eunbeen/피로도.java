import java.util.*;

class Solution {
    public boolean[] check = {};
    public int answer = -1;
    public int solution(int k, int[][] dungeons) {
        check = new boolean[dungeons.length];
        getAdventure(dungeons, k, 0);
        
        return answer < 0 ? 0 : answer;
    }
    private void getAdventure(int[][] dungeons, int k, int count){
        for(int i=0; i<dungeons.length; i++){
            if(!check[i] && dungeons[i][0] <= k){
                check[i] = true;
                getAdventure(dungeons, k -dungeons[i][1], count+1);
                check[i] = false;
            }
        }
        
        if (answer < count){
            answer = count;
        }
    }
}