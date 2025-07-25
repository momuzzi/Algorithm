import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        LinkedList<int[]> s = new LinkedList<>();
        
        for (int i = 0; i < prices.length; i++) {
            while (!s.isEmpty() && s.peekLast()[0] > prices[i]) {
                int[] poll = s.pollLast();
                int idx = poll[1];
                
                answer[idx] = i - idx; 
            }
            
            s.offerLast(new int[] {prices[i], i});
        }
        
        while (!s.isEmpty()) {
            int[] poll = s.pollLast();
            int idx = poll[1];
            
            answer[idx] = prices.length - 1 - idx;
        }
        
        return answer;
    }
}