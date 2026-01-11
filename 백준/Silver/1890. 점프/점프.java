import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp = new long[N][N];
        dp[0][0] = 1;

        int[] dx = {1, 0};
        int[] dy = {0, 1};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int how = graph[i][j];

                if (how == 0) continue;

                for (int k = 0; k < 2; k++) {
                    int x = i + how * dx[k];
                    int y = j + how * dy[k];

                    if (x >= N || y >= N) continue;

                    dp[x][y] += dp[i][j];
                }
            }
        }

        System.out.print(dp[N - 1][N - 1]);
    }
}