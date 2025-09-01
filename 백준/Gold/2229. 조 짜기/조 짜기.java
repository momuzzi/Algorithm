import java.io.*;
import java.util.*;

public class Main {

    static int[] scores;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        scores = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        int[] dp = new int[scores.length];

        for (int i = 1; i < dp.length; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int j = i; j >= 1; j--) {
                min = Math.min(scores[j], min);
                max = Math.max(scores[j], max);

                dp[i] = Math.max(dp[j - 1] + (max - min), dp[i]);
            }
        }

        System.out.print(dp[dp.length - 1]);
    }
}