import java.io.*;
import java.util.*;

public class Main {

    static int T;
    static int N;
    static int[] arr;
    static int M;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            M = Integer.parseInt(br.readLine());

            dp = new int[M + 1];
            dp[0] = 1;

            solve();
        }
    }

    static void solve() {
        for (int i = 0; i < N; i++) {
            for (int j = arr[i]; j <= M; j++) {
                dp[j] += dp[j - arr[i]];
            }
        }

        System.out.println(dp[M]);
    }
}