import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] graph;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bt(0, 1, 1, 0);

        System.out.print(ans);
    }

    static void bt(int depth, int x, int y, int sum) {
        if (depth == 3) {
            ans = Math.min(ans, sum);
            return;
        }

        for (int i = x; i < N; i++) {
            for (int j = (i == x ? y : 0); j < N; j++) {
                if (!visit[i][j] && can(i, j)) {
                    visit(i, j);
                    bt(depth + 1, j == N - 1 ? i + 1 : i, j == N - 1 ? 0 : j + 1, sum + fee(i, j));
                    cancel(i, j);
                }
            }
        }
    }

    static boolean can(int a, int b) {
        for (int i = 0; i < 4; i++) {
            int x = a + dx[i];
            int y = b + dy[i];

            if (x < 0 || x >= N || y < 0 || y >= N) return false;

            if (visit[x][y]) return false;
        }

        return true;
    }

    static void visit(int a, int b) {
        visit[a][b] = true;
        for (int i = 0; i < 4; i++) {
            visit[a + dx[i]][b + dy[i]] = true;
        }
    }

    static void cancel(int a, int b) {
        visit[a][b] = false;
        for (int i = 0; i < 4; i++) {
            visit[a + dx[i]][b + dy[i]] = false;
        }
    }

    static int fee(int a, int b) {
        int sum = graph[a][b];

        for (int i = 0; i < 4; i++) {
            sum += graph[a + dx[i]][b + dy[i]];
        }

        return sum;
    }
}