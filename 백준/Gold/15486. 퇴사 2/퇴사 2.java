import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] TP = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(TP[0]);
            arr[i][1] = Integer.parseInt(TP[1]);
        }

        int[] dp = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            int T = arr[i - 1][0];
            int P = arr[i - 1][1];

            dp[i] = Math.max(dp[i], dp[i - 1]);

            if (i + T <= N + 1) {
                dp[i + T] = Math.max(dp[i + T], dp[i] + P);
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i <= N + 1; i++) {
            ans = Math.max(ans, dp[i]);
        }

        System.out.print(ans);
    }
}