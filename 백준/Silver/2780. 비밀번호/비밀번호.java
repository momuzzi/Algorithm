import java.io.*;

public class Main {

    static BufferedReader br;
    static int T;
    static int N;
    static int[][] graph = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {0, 0, 0}};
    static int[] dx = {-1, 1, 0 ,0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] dp;
    static int MOD = 1234567;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
    }

    static void solve() throws Exception{
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            dp = new int[10][N + 1]; // ex) [1][2] 2자리 비밀번호일 때 끝이 1인 경우의 수 = [1과 인접한 번호][1] -> 1과 인접한 모든 번호 x의 [x][1]의 합

            for (int j = 0; j <= 9; j++) {
                dp[j][1] = 1;
            }

            for (int j = 2; j <= N; j++) {
                for (int k = 0; k < 4; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (k == 3) {
                            if (l != 0) break;
                        }
                        for (int m = 0; m < 4; m++) {
                            int moveX = k + dx[m];
                            int moveY = l + dy[m];

                            if (moveX < 0 || moveY < 0 || moveX > 3 || moveY > 2) continue;
                            if (moveX == 3 && moveY > 0) continue;

                            dp[graph[k][l]][j] = (dp[graph[k][l]][j] + dp[graph[moveX][moveY]][j - 1]) % MOD;
                        }
                    }
                }
            }

            int sum = 0;
            for (int j = 0; j <= 9; j++) {
                sum += dp[j][N];
            }

            System.out.println(sum % MOD);
        }
    }
}