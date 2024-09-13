import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        int[] arr = new int[N + 1];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        for (int i = 1; i<= N; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int[] dp = new int[N + 1];

        dp[0] = arr[1];
        dp[1] = arr[1]; // -1 , arr[2] -2
        for (int i = 2; i <= N; i++) {

            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
        }

        int max = -1001;
        for (int i : dp) {
            if (i > max) {
                max = i;
            }
        }

        if (dp[0] > max) {
            max = dp[0];
        }

        System.out.print(max);
    }
}