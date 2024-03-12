import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int pick = nums.length/2;
        Map<Integer, Integer> map = new HashMap();
        
        for(int monster : nums){
            map.put(monster, 1);
        }

        return map.size() >= pick ? pick : map.size();
    }
}