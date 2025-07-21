import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        LinkedList<Character> stack = new LinkedList<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                s = s.substring(1) + s.charAt(0);
            }
            
            boolean isGood = true;

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                
                if (c == '(' || c == '[' || c == '{') {
                    stack.offerLast(c);
                } else {
                    if (stack.isEmpty()) {
                        isGood = false;
                        break;
                    }

                    char pollC = stack.pollLast();

                    if ((c == ')' && pollC != '(') ||
                        (c == ']' && pollC != '[') ||
                        (c == '}' && pollC != '{')) {
                        isGood = false;
                        break;
                    }
                }
            }
            
            if (!stack.isEmpty()) {
                isGood = false;
                stack.clear();
            }

            if (isGood) {
                answer++;
            }
        }
        
        return answer;
    }
}
