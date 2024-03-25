import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        int h = citations[0];
        while(h <= citations[citations.length-1]){
            
            int num = h;
            int max = (int)Arrays.stream(citations).filter(e -> e >= num).count();

            if(max >= h){
                answer = Math.max(answer, h);
            }
            h += 1;
        }
        
        
        if(answer == 0 && citations.length < citations[0]){
            answer = citations.length;
        }
        
        return answer;
    }
}