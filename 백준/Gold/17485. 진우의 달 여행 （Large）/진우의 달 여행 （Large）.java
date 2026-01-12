import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        int[][] graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[3][N + 1][M];

        for (int i = 0; i < 3; i++) {
            for (int j = 1; j <= N; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        int[] dy = {-1, 0, 1};

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 3; k++) {
                    int x = i - 1;
                    int y = j + dy[k];

                    if (y < 0 || y >= M)
                        continue;

                    if (k == 0) {
                        dp[0][i][j] = Math.min(dp[1][x][y], dp[2][x][y]) + graph[i - 1][j];
                    }

                    if (k == 1) {
                        dp[1][i][j] = Math.min(dp[0][x][y], dp[2][x][y]) + graph[i - 1][j];
                    }

                    if (k == 2) {
                        dp[2][i][j] = Math.min(dp[0][x][y], dp[1][x][y]) + graph[i - 1][j];
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) {
                min = Math.min(min, dp[j][N][i]);
            }
        }

        System.out.print(min);
    }
}