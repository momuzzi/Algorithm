import java.util.*;

class Solution {
    
    static List<List<Town>> roads = new ArrayList<>();
    static int[] totalTimeArr;
    static int MAX = 10000 * 50 + 1;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        totalTimeArr = new int[N + 1];
        
        for (int i = 0; i <= N; i++) {
            totalTimeArr[i] = MAX;
            roads.add(new ArrayList<>());
        }
        
        for (int i = 0; i < road.length; i++) {
            int[] info = road[i];
            int from = info[0];
            int to = info[1];
            int need = info[2];
            
            roads.get(from).add(new Town(to, need));
            roads.get(to).add(new Town(from, need));
        }
        
        dijk(1, N);

        for (int i = 1; i < totalTimeArr.length; i++) {
            if (totalTimeArr[i] <= K) answer++;
        }

        return answer;
    }
    
    static void dijk(int start, int N) {
        PriorityQueue<Town> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.time, b.time));
        pq.offer(new Town(start, 0));
        totalTimeArr[start] = 0;
        
        while (!pq.isEmpty()) {
            Town town = pq.poll();
            
            for (Town nextTown : roads.get(town.num)) {
                if (town.time + nextTown.time < totalTimeArr[nextTown.num]) {
                    totalTimeArr[nextTown.num] = town.time + nextTown.time;
                    pq.offer(new Town(nextTown.num, totalTimeArr[nextTown.num]));
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