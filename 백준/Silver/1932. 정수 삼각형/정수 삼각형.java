import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());

        dp = new int[num + 1][num + 1];

        for (int i = 1; i <= num; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            int idx = 1;
            while (tokenizer.hasMoreTokens()) {
                dp[i][idx] = Integer.parseInt(tokenizer.nextToken());
                idx++;
            }
        }

        for (int i = 2; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                if (j == 1) {
                    dp[i][j] += dp[i - 1][j];
                } else if (i == j) {
                    dp[i][j] += dp[i - 1][j - 1];
                } else {
                    dp[i][j] += Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                }
            }
        }

        int max = dp[num][1];
        for (int i = 2; i <= num; i++) {
            if (dp[num][i] > max) {
                max = dp[num][i];
            }
        }

        System.out.print(max);
    }
}