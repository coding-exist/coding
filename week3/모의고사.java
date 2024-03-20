import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int score1 = 0;
        int score2 = 0;
        int score3 = 0;
        
        for(int i=0; i<answers.length; i++){
             score1 += answers[i] == student1[i%student1.length] ? 1 : 0;
             score2 += answers[i] == student2[i%student2.length] ? 1 : 0;
             score3 += answers[i] == student3[i%student3.length] ? 1 : 0;
        }
        
        if(score1 == score2 && score2 == score3) return new int[]{1, 2, 3};
        else {
            List<Integer> list = new ArrayList();
            int max = Math.max(score1, score2);
            max = Math.max(max, score3);
                    
            if(max == score1) list.add(1);            
            if(max == score2) list.add(2);            
            if(max == score3) list.add(3);
            
            return list.stream().mapToInt(i->i).toArray();
        }
    }
}