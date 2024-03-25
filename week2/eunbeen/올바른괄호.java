import java.util.*;

class Solution {
    boolean solution(String s) {
        int openCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                openCount++;
            } else if (ch == ')') {
                if (openCount == 0) {
                    return false;
                }
                openCount--;
            }
        }

        return openCount == 0;
    }
}