import java.util.*;

class Solution {
    
    static boolean[] visit;
    static int banWireIdx;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        for (int i = 0; i < wires.length; i++) {
            banWireIdx = i;
            
            visit = new boolean[n + 1];
            List<Integer> list = new ArrayList<>();
            int zoneCnt = 0;
            for (int j = 1; j <= n; j++) {
                if (!visit[j]) {
                    
                    if (zoneCnt == 2) {
                        zoneCnt++;
                        break;
                    }
                    
                    int cnt = bfs(j, wires);
                    list.add(cnt);
                    zoneCnt++;
                }
            }
            
            if (zoneCnt == 2) {
                int dif = Math.abs(list.get(0) - list.get(1));
                answer = Math.min(answer, dif);
            }
        }
        
        return answer;
    }
    
    static int bfs(int n, int[][] wires) {
        int cnt = 1;
        LinkedList<Integer> q = new LinkedList<>();
        visit[n] = true;
        q.offerLast(n);
        
        while (!q.isEmpty()) {
            int pollN = q.pollFirst();
        
            for (int i = 0; i < wires.length; i++) {
                if (i == banWireIdx) continue;
                
                if (wires[i][0] == pollN && !visit[wires[i][1]]) {
                    visit[wires[i][1]] = true;
                    q.offerLast(wires[i][1]);
                    cnt++;
                    
                    continue;
                }
                
                if (wires[i][1] == pollN && !visit[wires[i][0]]) {
                    visit[wires[i][0]] = true;
                    q.offerLast(wires[i][0]);
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}