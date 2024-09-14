import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        int[][] dp = new int[N + 1][10]; // [1 ~ N][0 ~ 9] [N일 때][젤 뒷자리가 x인 경우]

        dp[1][0] = 0;

        // dp[1][1~9] = 1로 초기화
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        if (N == 1) {
            System.out.print(9);
            return;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j + 1];
                    continue;
                }
                if (j == 9) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }

                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j  + 1]) % 1000000000;
            }
        }

        int answer = 0;
        for (int i = 0; i <= 9; i++) {
            answer += dp[N][i];
            answer %= 1000000000;
        }

        System.out.print(answer);
    }
}
