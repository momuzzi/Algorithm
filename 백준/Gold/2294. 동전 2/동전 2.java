import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int k;
    static int[] value;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);

        value = new int[n + 1];
        dp = new int[k + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 1; i <= n; i++) {
            value[i] = Integer.parseInt(br.readLine());
            if (value[i] <= k) {
                dp[value[i]] = 1;
            }
        }
    }

    static void solve() {
        for (int i = 1; i <= n; i++) {
            for (int j = value[i]; j <= k; j++) {
                if (dp[j - value[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - value[i]] + 1);
                }
            }
        }

        if (dp[k] == Integer.MAX_VALUE) {
            System.out.print(-1);
            return;
        }

        System.out.print(dp[k]);
    }
}