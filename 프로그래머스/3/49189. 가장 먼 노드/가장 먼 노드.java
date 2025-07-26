import java.util.*;

class Solution {
    
    static List<List<Integer>> edgeList = new ArrayList<>();
    static int[] graph;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        for (int i = 0; i <= n; i++) {
            edgeList.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edge.length; i++) {
            int[] e = edge[i];
            edgeList.get(e[0]).add(e[1]);
            edgeList.get(e[1]).add(e[0]);
        }
        
        graph = new int[n + 1];
        
        bfs();
        
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (graph[i] > max) {
                max = graph[i];
                answer = 1;
            } else if (graph[i] == max) {
                answer++;
            }
        }
        
        return answer;
    }
    
    static void bfs() {
        LinkedList<Integer> q = new LinkedList<>();
        
        q.offerLast(1);
        
        while (!q.isEmpty()) {
            int from = q.pollFirst();
            
            List<Integer> list = edgeList.get(from);
            for (int to : list) {
                if (graph[to] == 0 && to != 1) {
                    graph[to] = graph[from] + 1;
                    q.offerLast(to);
                }
            }
        }
    }
}