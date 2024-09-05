import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        StringBuilder builder = new StringBuilder();

        dp = new int[30][30];

        for (int i = 0; i < num; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            int N = Integer.parseInt(tokenizer.nextToken());
            int M = Integer.parseInt(tokenizer.nextToken());

            builder.append(comb(M, N)).append("\n");
        }
        System.out.print(builder);
    }

    static int comb(int m, int n) {

        if (dp[m][n] > 0) {
            return dp[m][n];
        }

        if (m == n || n == 0) {
            return dp[m][n] = 1;
        }

        if (n == 1) {
            return m;
        }

       else {
            return dp[m][n] = comb(m - 1, n) + comb(m - 1, n - 1);
        }
    }
}