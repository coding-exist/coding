import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> ready_queue = new LinkedList();
        Queue<Integer> bridge_queue = new LinkedList();
        
        //다리를 건너야 하는 트럭
        for(int truck : truck_weights){
            ready_queue.add(truck);
        }
        
        //다리 위에 있는 트럭
        for(int length : new int[bridge_length]){
            bridge_queue.add(length);
        }
        
        int total_weight = 0;
        while(total_weight != 0 || ready_queue.size() > 0){
            
            //다리 위에 있는 트럭은 다리를 다 건너게 함
            total_weight -= bridge_queue.remove();
            
            //ready 에 있는 트럭 중 올릴 수 있는 트럭 올림
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