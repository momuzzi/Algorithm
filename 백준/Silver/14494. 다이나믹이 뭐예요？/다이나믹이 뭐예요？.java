import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");

        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[][] dp = new int[n + 1][m + 1];
        dp[1][1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = (dp[i][j] + dp[i][j - 1]) % 1000000007;

                dp[i][j] = (dp[i][j] + dp[i - 1][j]) % 1000000007;

                dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % 1000000007;
            }
        }

        System.out.print(dp[n][m]);
    }
}