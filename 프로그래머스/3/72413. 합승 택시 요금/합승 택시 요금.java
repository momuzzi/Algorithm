import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        int MAX = 100_000 * 200 + 1;
        
        int[][] graph = new int[n + 1][n + 1];
        
        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], MAX);
            graph[i][i] = 0;
        }
        
        for (int i = 0; i < fares.length; i++) {
            int[] fare = fares[i];
            int from = fare[0];
            int to = fare[1];
            int cost = fare[2];
            
            graph[from][to] = cost;
            graph[to][from] = cost;
        }
        
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j] , graph[i][k] + graph[k][j]);
                }
            }
        }
        
        answer = graph[s][a] + graph[s][b];
        
        for (int i = 1; i <= n; i++) {
            if (i == s) continue;
            
            answer = Math.min(answer, graph[s][i] + graph[i][a] + graph[i][b]);
        }
        
        return answer;
    }
}