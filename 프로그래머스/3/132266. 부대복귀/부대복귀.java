import java.util.*;

class Solution {
    
    static int cnt;
    static boolean[] visit;
    static List<List<Integer>> graph = new ArrayList<>();
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        cnt = sources.length;
        visit = new boolean[n + 1];
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < roads.length; i++) {
            int[] info = roads[i];
            int a = info[0];
            int b = info[1];
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        int[] dis = new int[n + 1];
        
        bfs(destination, dis);
        
        for (int i = 0; i < sources.length; i++) {
            int num = sources[i];
            
            answer[i] = visit[num] ? dis[num] : -1;            
        }
        
        return answer;
    }
    
    static void bfs(int start, int[] dis) {
        LinkedList<Integer> q = new LinkedList<>();
        q.offerLast(start);
        visit[start] = true;
        
        while (!q.isEmpty()) {
            int poll = q.pollFirst();
            
            for (int to : graph.get(poll)) {
                if (!visit[to]) {
                    visit[to] = true;
                    dis[to] = dis[poll] + 1;
                    q.offerLast(to);
                }
            }
        }
    }
}