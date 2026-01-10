import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static boolean[] visit;
    static int[][] dist;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");
        N = Integer.parseInt(NK[0]);
        K = Integer.parseInt(NK[1]);

        visit = new boolean[N];

        dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j) continue;

                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        visit[K] = true;
        for (int i = 0; i < N; i++) {
            if (K == i) continue;
            visit[i] = true;
            bt(2, dist[K][i], i);
            visit[i] = false;
        }

        System.out.print(ans);
    }

    static void bt(int depth, int sum, int a) {
        if (depth == N) {
            ans = Math.min(ans, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (a == i) continue;

            if (!visit[i]) {
                visit[i] = true;
                bt(depth + 1, sum + dist[a][i], i);
                visit[i] = false;
            }
        }
    }
}