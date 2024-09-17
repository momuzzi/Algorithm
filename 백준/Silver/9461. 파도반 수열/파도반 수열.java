import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int N = Integer.parseInt(reader.readLine());
        long[] dp;
        for (int i = 1; i <= N; i++) {
            int n = Integer.parseInt(reader.readLine());
            dp = new long[n + 1];

            dp[1] = 1;
            if (n == 1) {
                builder.append(dp[1]).append("\n");
                continue;
            }

            dp[2] = 1;
            if (n == 2) {
                builder.append(dp[2]).append("\n");
                continue;
            }

            dp[3] = 1;
            if (n == 3) {
                builder.append(dp[3]).append("\n");
                continue;
            }

            for (int j = 4; j <= n; j++) {
                dp[j] = dp[j - 2] + dp[j - 3];
            }
            builder.append(dp[n]).append("\n");
        }

        System.out.print(builder);
    }
}