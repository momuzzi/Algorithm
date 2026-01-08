import java.io.*;
import java.util.*;

public class Main {

    static int A, B, C;
    static int[] from = {0, 0, 1, 1, 2, 2};
    static int[] to = {1, 2, 0, 2, 0, 1};
    static int[] other = {2, 1, 2, 0, 1, 0};
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        visit = new boolean[B + 1][C + 1];

        bfs();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i <= B; i++) {
            for (int j = 0; j <= C; j++) {
                if (visit[i][j] && i + j == C) {
                    pq.offer(j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll() + " ");
        }

        System.out.print(sb);
    }

    static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0, C});
        visit[0][C] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();

            for (int i = 0; i < 6; i++) {
                int f = from[i];
                int t = to[i];

                if (getBottleSize(t) - poll[t] == 0) continue;

                if (getBottleSize(t) - poll[t] >= poll[f]) {
                    int[] next = new int[3];
                    next[other[i]] = poll[other[i]];
                    next[f] = 0;
                    next[t] = poll[t] + poll[f];

                    if (visit[next[1]][next[2]]) continue;

                    visit[next[1]][next[2]] = true;

                    q.offer(next);

                }

                if (getBottleSize(t) - poll[t] < poll[f]) {
                    int[] next = new int[3];
                    next[other[i]] = poll[other[i]];
                    next[f] = poll[f] - (getBottleSize(t) - poll[t]);
                    next[t] = getBottleSize(t);

                    if (visit[next[1]][next[2]]) continue;

                    visit[next[1]][next[2]] = true;

                    q.offer(next);
                }
            }
        }
    }

    static int getBottleSize(int idx) {
        if (idx == 0) return A;
        if (idx == 1) return B;
        return C;
    }
}