import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int K;
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);

        arr = new int[K + 1][2];

        for (int i = 1; i <= K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        dp = new int[K + 1][N + 1];
    }

    static void solve() {
        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = dp[i - 1][j];

                if (j >= arr[i][1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - arr[i][1]] + arr[i][0]);
                }
            }
        }

        System.out.print(dp[K][N]);
    }
}