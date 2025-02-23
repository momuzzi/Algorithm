import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int[][] arr;
        int[][] dp;

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            arr = new int[2][n + 1];
            dp = new int[2][n + 1];

            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 1; k < n + 1; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];

            for (int j = 2; j < n + 1; j++) {
                dp[0][j] = Math.max(dp[1][j - 2], dp[1][j - 1]) + arr[0][j];
                dp[1][j] = Math.max(dp[0][j - 2], dp[0][j - 1]) + arr[1][j];
            }

            sb.append(Math.max(dp[0][n], dp[1][n]) + "\n");
        }
        
        System.out.print(sb);
    }
}