import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue();
        
        for(int rate : scoville){
            queue.add(rate);
        }
        
        while(queue.stream().anyMatch(e -> e < K) && queue.peek() < K && queue.size() >= 2){
            int first_food = queue.remove();
            int second_food = queue.remove();
            
            int mixed_food = first_food + (second_food * 2);
            queue.add(mixed_food);
            
            answer += 1;
        }
        
        if(queue.stream().anyMatch(e -> e < K)){
            return -1;
        }
        
        return answer;
    }
}