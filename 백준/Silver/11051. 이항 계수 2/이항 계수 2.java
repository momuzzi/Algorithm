import java.io.*;

public class Main {

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);

        dp = new int[N + 1][K + 1];

        int result = rf(N, K);

        System.out.print(result);
    }

    static int rf(int n, int k) {

        if (dp[n][k] != 0) {
            return dp[n][k];
        }

        if (k == 1) {
            dp[n][k] = n % 10007;
            return dp[n][k];
        }

        if (n == k || k == 0) {
            dp[n][k] = 1 % 10007;
            return dp[n][k];
        }

        return dp[n][k] = (rf(n - 1, k) + rf(n - 1, k - 1)) % 10007;
    }
}