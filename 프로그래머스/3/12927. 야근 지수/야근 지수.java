import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        
        for (int work : works) {
            pq.offer(work);
        }
        
        for (int i = 0; i < n; i++) {
            if (pq.isEmpty()) {
                return 0;
            }
            
            int poll = pq.poll() - 1;
            
            if (poll != 0) {
                pq.offer(poll);
            }
        }
        
        while (!pq.isEmpty()) {
            int poll = pq.poll();
            answer += poll * poll;
        }
        
        return answer;
    }
}