import java.util.*;

class Solution {
    public Set<Integer> set = new HashSet();
    String[] tracking = {};
    boolean[] check = {};
    public int solution(String numbers) {
        int answer = 0;
        
        tracking = numbers.split("");
        check = new boolean[tracking.length];
        
        permutation(0, "");
        
        Iterator<Integer> iter = set.iterator();
        while(iter.hasNext()){
            var num = iter.next();
            if(num == 2) answer += 1;
            answer += num%2 != 0 ? isPrime(num) : 0;
        }
        
        return answer;
    }
    private int isPrime(int num) {
        if(num <= 1) return 0;
        for(int i=2; i <= Math.sqrt(num); i++) {
            if(num%i==0) return 0;
        }
        return 1;
    }
    private void permutation(int index, String sum) {
        if (!sum.isEmpty()) {
            set.add(Integer.parseInt(sum));
        }
        
        for (int i = 0; i < tracking.length; i++) {
            if (!check[i]) {
                check[i] = true;
                permutation(index++, sum + tracking[i]);
                check[i] = false;
            }
        }
    }
}