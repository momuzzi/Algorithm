import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());

        int[] score = new int[num + 1]; // 각 계단에 점수를 넣을 배열
        int[][] dp = new int[2][num + 1]; // [0][x] 에는 바로 전 칸에서 올라온 값, [1][x] 에는 2칸전에서 한칸 건너뛰고 올라온 값

        // 계단별 점수 배열에 세팅
        for (int i = 1; i <= num; i++) {
            int n = Integer.parseInt(reader.readLine());
            score[i] = n;
        }

        dp[0][1] = score[1];
        dp[1][1] = 0;
        
        if (num > 1) {
            dp[0][2] = dp[0][1] + score[2];
            dp[1][2] = score[2];
        }

        if (num > 2) {
            for (int i = 3; i <= num; i++) {
                dp[0][i] = Math.max(dp[0][i - 2], dp[1][i - 1]) + score[i];
                dp[1][i] = Math.max(dp[0][i - 2], dp[1][i - 2]) + score[i];
            }
        }

        System.out.print(Math.max(dp[0][num], dp[1][num]));
    }
}