import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static int X;

    static List<Town>[] graph;
    static int[] timeArr;

    static class Town {
        int town;
        int roadTime;

        public Town(int town, int roadTime) {
            this.town = town;
            this.roadTime = roadTime;
        }
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        timeArr = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int fromTown = Integer.parseInt(st.nextToken());
            int toTown = Integer.parseInt(st.nextToken());
            int roadTime = Integer.parseInt(st.nextToken());

            graph[fromTown].add(new Town(toTown, roadTime));
        }
    }

    static void solve() {
        int answer = -1;

        for (int i = 1; i <= N; i++) {
            int totalTime = dijk(i, X) + dijk(X, i);
            answer = Math.max(answer, totalTime);
        }

        System.out.print(answer);
    }

    static int dijk(int start, int end) {
        PriorityQueue<Town> pq = new PriorityQueue<>((t1, t2) -> t1.roadTime - t2.roadTime);
        Arrays.fill(timeArr, Integer.MAX_VALUE);
        timeArr[start] = 0;

        pq.offer(new Town(start, 0));

        while (!pq.isEmpty()) {
            Town town = pq.poll();

            if (town.town == end) {
                break;
            }

            for (Town nextTown : graph[town.town]) {
                if (timeArr[nextTown.town] > town.roadTime + nextTown.roadTime) {
                    timeArr[nextTown.town] = town.roadTime + nextTown.roadTime;

                    pq.offer(new Town(nextTown.town, timeArr[nextTown.town]));
                }
            }
        }

        return timeArr[end];
    }

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }
}