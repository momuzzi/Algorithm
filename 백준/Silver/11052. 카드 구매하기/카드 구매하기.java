import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N + 1];
    }

    static void solve() {
        dp[0] = 0;
        dp[1] = arr[1];

        for (int i = 1; i <= N; i++) {
            for (int j = i; j >= 1; j--) {
                dp[i] = Math.max(dp[i - j] + arr[j], dp[i]);
            }
        }

        System.out.print(dp[N]);
    }
}