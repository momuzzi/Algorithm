import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");

        int[] arr = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int[] dp = new int[num + 1];
        int answer = 1;
        for (int i = 1; i <= num; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j] && dp[j] >= dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            answer = Math.max(answer, dp[i]);
        }
        System.out.print(answer);
    }
}