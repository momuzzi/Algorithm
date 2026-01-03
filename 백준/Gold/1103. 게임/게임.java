import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] graph;
    static boolean[][] visit;
    static int[][] dp;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean infinite = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");

        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        graph = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = s.charAt(j);
                if (c == 'H') {
                    graph[i][j] = -1;
                } else {
                    graph[i][j] = c - '0';
                }
            }
        }
        
        dp = new int[N][M];

        int res = dfs(0, 0);

        System.out.print(infinite ? -1 : res);
    }

    static int dfs(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M) return 0;

        if (graph[x][y] == -1) return 0;

        if (dp[x][y] != 0) return dp[x][y];

        if (visit[x][y]) {
            infinite = true;
            return 0;
        }

        visit[x][y] = true;
        int max = 0;
        for (int i = 0; i < 4; i++) {
            int mx = x + graph[x][y] * dx[i];
            int my = y + graph[x][y] * dy[i];

            max = Math.max(max, dfs(mx, my));
        }
        visit[x][y] = false;

        dp[x][y] = max + 1;

        return dp[x][y];
    }
}