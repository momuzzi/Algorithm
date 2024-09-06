import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int[] dp = new int[n + 1];

        if (n >= 1) {
            dp[1] = 1;
        }

        if (n >= 2) {
            dp[2] = 2;
        }

        if (n == 1) {
            System.out.print(dp[1] % 10007);
        }

        if (n == 2) {
            System.out.print(dp[2] % 10007);
        }

        if (n > 2) {
            int idx = 3;
            while (idx <= n) {
                dp[idx] = (dp[idx - 1] + dp[idx - 2]) % 10007;
                idx++;
            }

            System.out.print(dp[n]);
        }
    }
}