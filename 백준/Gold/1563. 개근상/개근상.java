import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][][] dp = new int[N + 1][2][3];
        dp[0][0][0] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j][k]) % 1_000_000;

                    if (j == 0) {
                        dp[i][1][0] = (dp[i][1][0] + dp[i - 1][0][k]) % 1_000_000;
                    }

                    if (k < 2) {
                        dp[i][j][k + 1] = (dp[i][j][k + 1] + dp[i - 1][j][k]) % 1_000_000;
                    }
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++){
                sum = (sum + dp[N][i][j]) % 1_000_000;
            }
        }

        System.out.print(sum);
    }
}