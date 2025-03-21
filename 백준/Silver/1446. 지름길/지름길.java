import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int D;
    static List<Road>[] graph;
    static int[] dist;

    static class Road {
        int to;
        int length;

        public Road(int to, int length) {
            this.to = to;
            this.length = length;
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        graph = new ArrayList[D + 1];

        for (int i = 0; i <= D; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < D; i++) {
            graph[i].add(new Road(i + 1, 1));
        }

        dist = new int[D + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            if (end > D) continue;

            graph[start].add(new Road(end, length));
        }
    }

    static void solve() {
        PriorityQueue<Road> pq = new PriorityQueue<>((r1, r2) -> r1.length - r2.length);
        pq.offer(new Road(0, 0));
        dist[0] = 0;

        while (!pq.isEmpty()) {
            Road now = pq.poll();

            for (Road next : graph[now.to]) {
                if (now.length + next.length < dist[next.to]) {
                    dist[next.to] = now.length + next.length;
                    pq.offer(new Road(next.to, dist[next.to]));
                }
            }
        }

        System.out.print(dist[D]);
    }
}