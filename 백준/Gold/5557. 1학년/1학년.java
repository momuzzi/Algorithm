import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        long[][] dp = new long[N - 1][21]; // i번째 숫자까지 사용해서 0~20을 만드는 경우의 수
        dp[0][arr[0]] = 1;

        for (int i = 1; i < N - 1; i++) {
            for (int j = 0; j <= 20; j++) {
                // arr[i]를 더한 경우
                if (j + arr[i] <= 20) {
                    dp[i][j + arr[i]] += dp[i - 1][j];
                }

                // arr[i]를 뺀 경우
                if (j - arr[i] >= 0) {
                    dp[i][j - arr[i]] += dp[i - 1][j];
                }
            }
        }

        System.out.print(dp[N - 2][arr[N - 1]]);
    }
}