import java.util.*;

class Solution {
    
    static LinkedList<Integer> q;
    static int comN;
    static boolean[] visit;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        comN = n; 
        
        visit = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                q = new LinkedList<>();
                q.offerLast(i);
                visit[i] = true;
                bfs(i, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    static void bfs(int n, int[][] computers) {
        while (!q.isEmpty()) {
            int poll = q.pollFirst();
            
            for (int i = 0; i < comN; i++) {
                if (computers[poll][i] == 1 && !visit[i]) {
                    visit[i] = true;
                    q.offerLast(i);
                }
            }
        }
    }
}