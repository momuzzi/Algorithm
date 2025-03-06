import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] arr;
    static int K;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][2];

        for (int i = 1; i <= N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // i번째에서 작은 점프에 필요한 에너지
            arr[i][1] = Integer.parseInt(st.nextToken()); // i번째에서 큰 점프에 필요한 에너지
        }

        K = Integer.parseInt(br.readLine());
    }

    static void solve() {
        if (N == 1) {
            System.out.print(0);
            return;
        }

        if (N == 2) {
            System.out.println(arr[1][0]);
            return;
        }

        if (N == 3) {
            System.out.println(Math.min(arr[1][0] + arr[2][0], arr[1][1]));
            return;
        }

        int[][] dp = new int[N + 1][2];
        dp[2][0] = arr[1][0];
        dp[3][0] = Math.min(arr[1][1], dp[2][0] + arr[2][0]);

        dp[2][1] = 10_000_000;
        dp[3][1] = 10_000_000;

        for (int i = 4; i <= N; i++) {
            dp[i][0] = Math.min(dp[i - 1][0] + arr[i - 1][0], dp[i - 2][0] + arr[i - 2][1]);
            dp[i][1] = Math.min(dp[i - 3][0] + K, Math.min(dp[i - 1][1] + arr[i - 1][0], dp[i - 2][1] + arr[i - 2][1]));
        }

        System.out.print(Math.min(dp[N][0], dp[N][1]));
    }
}