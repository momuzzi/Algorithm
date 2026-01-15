import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][3];
        for (int i = 0; i < N; i++) {
            String[] rgb = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(rgb[0]);
            arr[i][1] = Integer.parseInt(rgb[1]);
            arr[i][2] = Integer.parseInt(rgb[2]);
        }

        int[][][] dp = new int[3][N][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        
        dp[0][0][0] = arr[0][0];
        dp[1][0][1] = arr[0][1];
        dp[2][0][2] = arr[0][2];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (i < N - 1 || k != j) {
                        if (k == 0) {
                            if (dp[j][i - 1][1] != Integer.MAX_VALUE || dp[j][i - 1][2] != Integer.MAX_VALUE) {
                                dp[j][i][k] = Math.min(dp[j][i - 1][1], dp[j][i - 1][2]) + arr[i][0];
                            }
                        }

                        if (k == 1) {
                            if (dp[j][i - 1][0] != Integer.MAX_VALUE || dp[j][i - 1][2] != Integer.MAX_VALUE) {
                                dp[j][i][k] = Math.min(dp[j][i - 1][0], dp[j][i - 1][2]) + arr[i][1];
                            }
                        }

                        if (k == 2) {
                            if (dp[j][i - 1][0] != Integer.MAX_VALUE || dp[j][i - 1][1] != Integer.MAX_VALUE) {
                                dp[j][i][k] = Math.min(dp[j][i - 1][0], dp[j][i - 1][1]) + arr[i][2];
                            }
                        }
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                min = Math.min(min, dp[i][N - 1][j]);
            }
        }

        System.out.print(min);
    }
}