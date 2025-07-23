import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : scoville) {
            pq.offer(n);
        }
        
        while (true) {
            if (pq.peek() >= K) break;
            
            if (pq.size() < 2) break;
            
            int firstN = pq.poll();
            int secondN = pq.poll();
            
            int newN = firstN + secondN * 2;
            
            pq.offer(newN);
            
            answer++;
        }
        
        if (pq.peek() < K) {
            answer = -1;
        }
        
        return answer;
    }
}