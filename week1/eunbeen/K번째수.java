import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        List<Integer> list = new ArrayList();
        
        for(int z=0; z<commands.length; z++){
            int i = commands[z][0];
            int j = commands[z][1];
            int k = commands[z][2];
            
            System.out.println(i  +" " + j + " " + k);
            for(int x=i-1; x<j; x++){
                list.add(array[x]);
            }
            
            Collections.sort(list);
            answer[z] = list.get(k-1);
            
            list.clear();
        }
        
        return answer;
    }
}