import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());

        int[] cArr = new int[c];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < c; i++) {
            cArr[i] = Integer.parseInt(st.nextToken());
            sum += cArr[i];
        }

        int g = Integer.parseInt(br.readLine());

        int[] gArr = new int[g];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < g; i++) {
            gArr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[c + 1][sum + 1];
        dp[0][0] = true;

        for (int i = 0; i < c; i++) {
            int w = cArr[i];
            for (int j = 0; j <= sum; j++) {
                if (dp[i][j]) {
                    dp[i + 1][j] = true;
                    if (j + w <= sum) dp[i + 1][j + w] = true;
                    dp[i + 1][Math.abs(j - w)] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < g; i++) {
            int gg = gArr[i];
            
            if (gg <= sum && dp[c][gg]) {
                sb.append("Y ");
            } else {
                sb.append("N ");
            }
        }

        System.out.print(sb);
    }
}