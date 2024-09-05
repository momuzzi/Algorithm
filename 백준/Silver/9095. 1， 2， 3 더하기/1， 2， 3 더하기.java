import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < num; i++) {
            int N = Integer.parseInt(reader.readLine());
            int[] dp = new int[11];
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for (int j = 4; j <= N; j++) {
                dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
            }
            builder.append(dp[N]).append("\n");
        }

        System.out.println(builder);
    }
}