import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        PriorityQueue<Integer> aq = new PriorityQueue<>();
        
        for (int a : A) {
            aq.offer(a);
        }
        
        PriorityQueue<Integer> bq = new PriorityQueue<>();
        
        for (int b : B) {
            bq.offer(b);
        }
        
        while (!bq.isEmpty()) {
            int a = aq.peek();
            int b = bq.peek();
            
            if (b > a) {
                aq.poll();
                answer++;
            }
            
            bq.poll();     
        }
        
        return answer;
    }
}