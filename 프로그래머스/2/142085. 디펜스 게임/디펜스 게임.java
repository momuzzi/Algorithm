import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        int l = 1;
        int h = enemy.length;
        
        while (l <= h) {
            int m = (l + h) / 2;
            
            if (can(m, n, k, enemy)) {
                l = m + 1;
                answer = m;
            } else {
                h = m - 1;
            }
        }
        
        return answer;
    }
    
    static boolean can(int m, int n, int k, int[] enemy) {   
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        
        for (int i = 0; i < m; i++) {
            pq.offer(enemy[i]);
        }
        
        while (!pq.isEmpty()) {
            int poll = pq.poll();
            if (k > 0) {
                k--;
                continue;
            } else {
                if (n >= poll) {
                    n -= poll;
                } else {
                    return false;
                }
            }
        }
        
        return true;
    }
}