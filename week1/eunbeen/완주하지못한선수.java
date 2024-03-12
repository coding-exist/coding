import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap();
        
        for(String name : completion) {
            map.putIfAbsent(name, 0);
            map.compute(name, (k, v) -> v + 1);
        }
        
        for(String name : participant) {
            if(!map.containsKey(name)){
                return name;
            }
            else if(map.get(name) > 1){
                map.compute(name, (k, v) -> v - 1);
            }
            else{
              map.remove(name);
            }
        }
        
        return map.values().toString();
    }
}