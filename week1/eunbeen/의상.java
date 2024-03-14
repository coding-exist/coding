import java.util.*;

class Solution {
    static int answer = 1;
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap();
        
        for(String[] values : clothes){
            String type = values[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        map.forEach((key, value) -> {
            answer *= value + 1;
        });
        
        return answer-1;
    }
}