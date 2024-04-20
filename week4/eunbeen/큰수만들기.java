import java.util.*;

class Solution {
    public String solution(String number, int k) {
        if(number.length() == k) return number;
        
        Stack<Character> stack = new Stack();
        var result = new StringBuilder();
        
        for(int i=0; i<number.length(); i++){
            char c = number.charAt(i);
            while (!stack.isEmpty() && k > 0 && stack.peek() < c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        
        while (k-- > 0) {
            stack.pop();
        }

        for (char c : stack) {
            result.append(c);
        }
        
        return result.toString();
    }
}