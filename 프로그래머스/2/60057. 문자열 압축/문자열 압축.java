import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        
        if (s.length() == 1) {
            return 1;
        }
        
        LinkedList<String> stack = new LinkedList<>();
        
        for (int i = 1; i <= s.length() / 2; i++) {
            int idx = 0;
            StringBuilder sb = new StringBuilder();
            while (idx < s.length()) {
                int to = idx + i;
                String slice = "";
                if (to < s.length()) {
                    slice = s.substring(idx, to);
                    idx = to;
                } else {
                    slice = s.substring(idx);
                    idx = s.length();
                }
                
                if (stack.isEmpty()) {
                    stack.offerLast(slice);
                } else {
                    if (stack.peekLast().equals(slice)) {
                        stack.offerLast(slice);
                    } else {
                        if (stack.size() == 1) {
                            sb.append(stack.peekLast());
                        } else {
                            sb.append(String.valueOf(stack.size()) + stack.peekLast());
                        }
                        
                        while (!stack.isEmpty()) {
                            stack.pollLast();
                        }
                        
                        stack.offerLast(slice);
                    }
                }
            }
            
            if (!stack.isEmpty()) {
                if (stack.size() == 1) {
                    sb.append(stack.peekLast());
                } else {
                    sb.append(String.valueOf(stack.size()) + stack.peekLast());
                }
                
                while (!stack.isEmpty()) {
                    stack.pollLast();
                }
            }
            
            answer = Math.min(answer, sb.length());
        }
        
        return answer;
    }
}