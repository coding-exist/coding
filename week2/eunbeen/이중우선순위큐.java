import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0 ,0};
        
        PriorityQueue<Integer> queue = new PriorityQueue();
        List<Integer> temp = new LinkedList();
        
        for(var operation: operations){
            String[] arr = operation.split(" ");
            char op = arr[0].charAt(0);
            int num = Integer.parseInt(arr[1]);
            
            if(op == 'I'){
                queue.add(num);
            }
            else if(queue.size() == 0){
                continue;
            }
            else if(op == 'D' && num == -1){
                queue.remove();
            }
            else{
                if(queue.size() == 1){
                    queue.remove();
                    continue;
                }
                while(queue.size() > 1){
                    temp.add(queue.remove());
                }
                queue.clear();
                for(int tempNum : temp){
                    queue.add(tempNum);
                }
                temp = new LinkedList();
            }
            
        }
        
        if(queue.size() > 0){
            int min = queue.remove();
            while(queue.size() > 1){
                queue.remove();
            }
            int max = queue.remove();
            
            return new int[]{max, min};
        }
        
        return answer;
    }
}