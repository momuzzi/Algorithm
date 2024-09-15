import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        int[][] house = new int[N + 1][3]; // [i번집][0 = 빨 비용, 1 = 초 비용, 2 = 파 비용]
        int[][] dp = new int[N + 1][3]; // [i][0] : i번째 집이 빨강으로 칠할 수 있는 경우 중 최소값, [i][1] : i번째 집이 초록으로 칠할 수 있는 경우 중 최소값, [i][2] : i번째 집이 파랑으로 칠할 수 있는 경우 중 최소값

        for (int i = 1; i <= N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            house[i][0] = Integer.parseInt(tokenizer.nextToken());
            house[i][1] = Integer.parseInt(tokenizer.nextToken());
            house[i][2] = Integer.parseInt(tokenizer.nextToken());
        }

        dp[1][0] = house[1][0];
        dp[1][1] = house[1][1];
        dp[1][2] = house[1][2];

        for (int i = 2; i <= N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1] + house[i][0], dp[i - 1][2] + house[i][0]); // 이번에 빨강으로 칠하려면 전집이 초 or 파로 칠한거에서 합한 것 중 최소
            dp[i][1] = Math.min(dp[i - 1][0] + house[i][1], dp[i - 1][2] + house[i][1]); // 이번에 초록으로 칠하려면 전집이 빨 or 파로 칠한거에서 합한 것 중 최소
            dp[i][2] = Math.min(dp[i - 1][0] + house[i][2], dp[i - 1][1] + house[i][2]); // 이번에 파랑으로 칠하려면 전집이 빨 or 초로 칠한거에서 합한 것 중 최소
        }

        int min = dp[N][0];
        for (int i = 1; i < 3; i++) {
            if (dp[N][i] < min) {
                min = dp[N][i];
            }
        }

        System.out.print(min);
    }
}