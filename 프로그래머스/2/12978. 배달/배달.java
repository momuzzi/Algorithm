import java.util.*;

class Solution {
    
    static int[][] roads;
    static int[] totalTimeArr;
    static int MAX = 10000 * 50 + 1;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        roads = new int[N + 1][N + 1];
        totalTimeArr = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
            Arrays.fill(roads[i], MAX);
            totalTimeArr[i] = MAX;
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
        
        totalTimeArr[1] = 0;
        dijk(1, N);

        for (int i = 1; i < totalTimeArr.length; i++) {
            if (totalTimeArr[i] <= K) answer++;
        }

        return answer;
    }
    
    static void dijk(int start, int N) {
        PriorityQueue<Town> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.time, b.time));
        pq.offer(new Town(1, 0));
        
        while (!pq.isEmpty()) {
            Town town = pq.poll();
            
            for (int i = 1; i <= N; i++) {
                if (town.num == i) continue;
                                
                if (town.time + roads[town.num][i] < totalTimeArr[i]) {
                    totalTimeArr[i] = town.time + roads[town.num][i];
                    pq.offer(new Town(i, totalTimeArr[i]));
                }
            }
        }
    }
    
    static class Town {
        int num;
        int time;
        
        Town(int num, int time) {
            this.num = num;
            this.time = time;
        }
    }
}