import java.io.*;
import java.util.*;

public class Main {

    static int T;
    static int W;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        arr = new int[T + 1];

        for (int i = 1; i <= T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }

    static void solve() {
        int[][] dp = new int[T + 1][W + 1]; // [1 ~ T] 초일 때, [0 ~ W] 움직인 횟수일 때 => 획득한 자두 수

        for (int i = 1; i <= T; i++) {
            if (arr[i] == 1) {
                dp[i][0] = dp[i - 1][0] + 1;
            }

            if (arr[i] == 2) {
                dp[i][0] = dp[i - 1][0];
            }

            for (int j = 1; j <= W; j++) {
                if (arr[i] == 1) { // 현재 자두가 1번 나무에서 떨어질 때
                    if (j % 2 == 0) { // 현재 1번 나무에 위치한 경우
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + 1;
                    } else { // 2번 나무에 위치한 경우
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
                    }
                } else { // 현재 자두가 2번 나무에서 떨어질 때
                    if (j % 2 == 1) { // 현재 2번 나무에 위치한 경우
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + 1;
                    } else { // 1번 나무에 위치한 경우
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i <= W; i++) {
            max = Math.max(max, dp[T][i]);
        }

        System.out.print(max);
    }
}