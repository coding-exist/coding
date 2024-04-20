import java.util.*;
class Solution {
    public int solution(String name) {
        
        char[] names = name.toCharArray();
        
        // A를 만났으면 해당 A까지 가장 짧게 올 수 있는 경우의 수
        int answer = names.length - 1;
        int lastA = 0;
        for(int i=1; i<names.length; i++){
            if(names[i] == 'A'){
                int front = i - 1;
                while (i < names.length && names[i] == 'A'){
                    i++;
                }
                
                int back = names.length - i;
                
                
                answer = Math.min(answer, 2 * back + front);
                answer = Math.min(answer, 2 * front + back);
                
                lastA = i;
            }
        }
        
         for(int i=0; i<names.length; i++){
            if(names[i] != 'A'){
                int toA = Math.abs(names[i] - 'A');
                int toZ = Math.abs('Z' - names[i]) + 1;
                
                answer += Math.min(toA, toZ);
            }
        }
        
                
        return answer;
    }
}