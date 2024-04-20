import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        Queue<Integer> queue1 = new LinkedList();
        Queue<Integer> queue2 = new LinkedList();
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i] == reserve[j]){
                    lost[i] = -1;
                    reserve[j] = -1;
                }
            }
        }
        
        for(int i : lost){
            if(i == -1) continue;
            queue1.add(i);
        }
        
        for(int i : reserve){
            if(i == -1) continue;
            queue2.add(i);
        }
        
        if(queue2.size() == 0){
            return n-queue1.size();
        }
        
        System.out.println(queue1 + " " + queue2);
        while(queue2.size() > 0){
            int num = queue2.remove();
            
            while(queue1.size() > 0 && queue1.peek() < (num+2)){
                int num2 = Math.abs(queue1.remove() - num);
                if(num2 != 1){
                    n--;
                }
                else {
                    break;
                }
            }
            
        }
         if(queue1.size() > 0){
            return n-queue1.size();
        }
        System.out.println(queue1 + " " + queue2);
        
        return n;
    }
}