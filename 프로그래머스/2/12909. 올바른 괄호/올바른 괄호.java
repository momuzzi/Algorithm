import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        LinkedList<Character> stack = new LinkedList<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ('(')) {
                stack.offerLast(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    answer = false;
                    break;
                } else {
                    stack.pollLast();
                }
            }
        }
        
        if (!stack.isEmpty()) {
            answer = false;
        }
        
        return answer;
    }
}