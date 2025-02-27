import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] criteria = br.readLine().toCharArray();
        char[] compareTarget = br.readLine().toCharArray();

        int[][] dp = new int[criteria.length + 1][compareTarget.length + 1];

        for (int i = 1; i <= criteria.length; i++) {
            for (int j = 1; j <= compareTarget.length; j++) {
                if (criteria[i - 1] == compareTarget[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        System.out.print(dp[criteria.length][compareTarget.length]);
    }
}