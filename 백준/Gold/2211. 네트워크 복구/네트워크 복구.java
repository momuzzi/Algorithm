import java.io.*;
import java.util.*;

public class Main {

    static List<List<int[]>> graph = new ArrayList<>();
    static int[] dist;
    static int[] before;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph.get(A).add(new int[] {B, C});
            graph.get(B).add(new int[] {A, C});
        }

        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        before = new int[N + 1];

        dijk();

        StringBuilder sb = new StringBuilder();
        sb.append(N - 1 + "\n");

        for (int i = 2; i <= N; i++) {
            sb.append(i + " " + before[i] + "\n");
        }

        System.out.print(sb);
    }

    static void dijk() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] {1, 0, 0});
        dist[1] = 0;

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();

            if (dist[poll[0]] == poll[1]) {
                before[poll[0]] = poll[2];
            }

            List<int[]> list = graph.get(poll[0]);

            for (int[] next : list) {
                if (dist[next[0]] > dist[poll[0]] + next[1]) {
                    dist[next[0]] = dist[poll[0]] + next[1];
                    pq.offer(new int[] {next[0], dist[next[0]], poll[0]});
                }
            }
        }
    }
}