import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        boolean[] arr = new boolean[N + 1];
        arr[0] = true;

        for (int i = 0; i < M; i++) {
            int n = Integer.parseInt(br.readLine());
            arr[n] = true;
        }

        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            if (arr[i]) {
                dp[i] = dp[i - 1];
            } else if (arr[i - 1]) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 2] + dp[i - 1];
            }
        }

        System.out.print(dp[N]);
    }
}