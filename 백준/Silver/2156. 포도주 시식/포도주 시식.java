import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        int[] wine = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
            int amount = Integer.parseInt(reader.readLine());
            wine[i] = amount;
        }

        int[] dp = new int[N + 1];

        dp[1] = wine[1];

        if (N > 1) {
            dp[2] = wine[1] + wine[2];
        }

        for (int i = 3; i <= N; i++) {
            // (1, 2), (1, 3), (2, 3) 
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]));
        }

        System.out.print(dp[N]);
    }
}