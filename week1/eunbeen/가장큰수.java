import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        var answer = new StringBuilder();
        List<String> array = new ArrayList();
        
        for(int num : numbers){
            array.add(String.valueOf(num));
        }
        
        Collections.sort(array, (o1, o2) -> {
            String a = o1 + o2;
            String b = o2 + o1;
            
            return b.compareTo(a);
        });
        
        if(array.get(0).equals("0")) return "0";
        for(String num : array){
            answer.append(num);
        }
        
        return answer.toString();
    }
}