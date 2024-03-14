import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList();
        Queue<Integer> queue = new LinkedList();

        for(int i=0; i<progresses.length; i++){
            int day = (int)Math.ceil((double)(100-progresses[i])/speeds[i]);
            queue.add(day);
        }
        
        int count = 1;
        int release = queue.remove();
        
        while(queue.size() > 0){
            if(release >= queue.peek()){
                count += 1;
                queue.remove();
            }
            else{
                answer.add(count);
                count = 1;
                release = queue.remove();
            }
        }
        
        if(count >= 1) answer.add(count);
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}