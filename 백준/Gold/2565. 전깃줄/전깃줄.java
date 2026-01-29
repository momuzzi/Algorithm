import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];

        int maxA = 0;
        int maxB = 0;
        for (int i = 0; i < n ; i++) {
            String[] ab = br.readLine().split(" ");

            arr[i][0] = Integer.parseInt(ab[0]);
            arr[i][1] = Integer.parseInt(ab[1]);

            maxA = Math.max(maxA, arr[i][0]);
            maxB = Math.max(maxB, arr[i][1]);
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int[][] dp = new int[maxA + 1][maxB + 1];
        for (int i = 0; i < n; i++) {
            dp[arr[i][0]][arr[i][1]] = 1;
        }

        for (int i = 0 ; i < n; i++) {
            int a = arr[i][0];
            int b = arr[i][1];

            int max = 0;
            for (int j = 1; j < a; j++) {
                for (int k = 1; k < b; k++) {
                    max = Math.max(max, dp[j][k]);
                }
            }

            dp[a][b] += max;
        }

        int max = 0;
        for (int i = 1; i <= maxA; i++) {
            for (int j = 1; j <= maxB; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }

        System.out.print(n - max);
    }
}