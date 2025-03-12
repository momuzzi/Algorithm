import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int T;
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
        T = Integer.parseInt(s[1]);

        arr = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N + 1][T + 1];
    }

    static void solve() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= T; j++) {
                dp[i][j] = dp[i - 1][j];

                if (j >= arr[i][0]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - arr[i][0]] + arr[i][1]);
                }
            }
        }

        System.out.print(dp[N][T]);
    }
}