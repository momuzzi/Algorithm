import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static int[][] graph;
    static boolean[][] visit;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solve() {
        bt(0, 0, 0, 0);
        System.out.print(max);
    }

    static void bt(int cnt, int sum, int x, int y) {
        if (cnt == K) {
            max = Math.max(sum, max);
            return;
        }

        for (int i = x; i < N; i++) {
            for (int j = (i == x ? y : 0); j < M; j++) {
                if (visit[i][j]) continue;
                if (cantChoice(i, j)) continue;

                visit[i][j] = true;

                int nextI = i;
                int nextJ = j + 1;

                if (nextJ == M) {
                    nextI = i + 1;
                    nextJ = 0;
                }

                bt(cnt + 1, sum + graph[i][j], nextI, nextJ);

                visit[i][j] = false;
            }
        }
    }

    static boolean cantChoice(int x, int y) {
        int[] dx = {-1, 0};
        int[] dy = {0, -1};

        for (int i = 0; i < 2; i++) {
            int moveX = x + dx[i];
            int moveY = y + dy[i];

            if (moveX < 0 || moveY < 0 || moveX >= N || moveY >= M) continue;

            if (visit[moveX][moveY]) return true;
        }

        return false;
    }
}