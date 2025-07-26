import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        LinkedList<Integer> s = new LinkedList<>();
        
        int idx = 0;
        while (k > 0) {    
            if (idx == number.length()) break;
            
            int num = number.charAt(idx) - '0';
            
            if (s.isEmpty()) {
                s.offerLast(num);
                idx++;
            } else {
                if (s.peekLast() >= num) {
                    s.offerLast(num);
                    idx++;
                } else {
                    s.pollLast();
                    k--;
                }
            }
            
        }
        
        answer = number.substring(idx, number.length());
        
        String front = "";
        while (!s.isEmpty()) {
            front += s.pollFirst();
        }
        
        answer = front + answer;
        
        if (k > 0) {
            answer = answer.substring(0, answer.length() - k);
        }
        
        return answer;
    }
}