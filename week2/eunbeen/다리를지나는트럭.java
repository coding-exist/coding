import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> ready_queue = new LinkedList();
        Queue<Integer> bridge_queue = new LinkedList();
        
        for(int truck : truck_weights){
            ready_queue.add(truck);
        }
        
        for(int length : new int[bridge_length]){
            bridge_queue.add(length);
        }
        
        int total_weight = 0;
        while(total_weight != 0 || ready_queue.size() > 0){

            total_weight -= bridge_queue.remove();
            
            int next_truck = 0;
            if(ready_queue.size() > 0 && total_weight + ready_queue.peek() <= weight){
                next_truck = ready_queue.remove();
                total_weight += next_truck;
            }
            
            bridge_queue.add(next_truck);
            answer += 1;
        }
        

        return answer;
    }
}