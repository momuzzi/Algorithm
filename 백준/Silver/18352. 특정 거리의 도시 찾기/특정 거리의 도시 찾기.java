import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K, X;
    static boolean[] visit;
    static List<List<Integer>> graph = new ArrayList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        visit = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            String[] AB = br.readLine().split(" ");
            graph.get(Integer.parseInt(AB[0])).add(Integer.parseInt(AB[1]));
        }

        bfs();

        if (pq.isEmpty()) {
            System.out.print(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll() + "\n");
        }

        System.out.print(sb);
    }

    static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {X, 0});
        visit[X] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();

            if (poll[1] == K) {
                pq.offer(poll[0]);
                continue;
            }

            List<Integer> list = graph.get(poll[0]);
            for (int n : list) {
                if (!visit[n]) {
                    visit[n] = true;
                    q.offer(new int[] {n, poll[1] + 1});
                }
            }
        }
    }
}