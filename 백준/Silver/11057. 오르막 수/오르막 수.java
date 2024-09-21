import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int[][] dp = new int[n + 1][10]; // n번째 자리에서 젤 뒷자리가 x일 때

        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        if (n == 1) {
            System.out.print(10);
            return;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] %= 10007;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum += dp[n][i];
            sum %= 10007;
        }

        System.out.print(sum);
    }
}