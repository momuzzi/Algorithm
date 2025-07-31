import java.util.*;

class Solution {
    
    static int[][] roads;
    static int MAX = 500001;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        roads = new int[N + 1][N + 1];
        
        for (int i = 1; i <= N; i++) {
            Arrays.fill(roads[i], MAX);
            roads[i][i] = 0;
        }

        for (int i = 0; i < road.length; i++) {
            int[] info = road[i];
            int from = info[0];
            int to = info[1];
            int need = info[2];
            
            roads[from][to] = Math.min(roads[from][to], need);
            roads[to][from] = Math.min(roads[to][from], need);
        }
        
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    roads[i][j] = Math.min(roads[i][j], roads[i][k] + roads[k][j]);
                }
            }
        }
        
        for (int i = 1; i <= N; i++) {
           if (roads[1][i] <= K) answer++; 
        }

        return answer;
    }
}