import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<Integer, Integer> len = new HashMap();
        Map<String, Integer> map = new HashMap();
        
        for(String phone : phone_book){
            if(map.containsKey(phone)){
                return false;
            }
            len.put(phone.length(), phone.length());
            map.put(phone, 0);
        }
        
        for(int size : len.values()){
            for(String phone : phone_book){
                if(phone.length() > size){
                    String re_phone = phone.substring(0, size);
                    if(map.containsKey(re_phone)){
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}