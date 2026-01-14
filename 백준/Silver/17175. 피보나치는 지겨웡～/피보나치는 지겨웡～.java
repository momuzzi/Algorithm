import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n < 2) {
            System.out.print(1);
            return;
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);

        for (int i = 2; i <= n; i++) {
            dp[i] += (dp[i - 1] + dp[i - 2]) % 1000000007;
        }

        System.out.print(dp[n]);
    }
}