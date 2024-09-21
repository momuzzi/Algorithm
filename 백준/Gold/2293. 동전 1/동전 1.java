import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] s = reader.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);

        int[] dp = new int[K + 1];
        dp[0] = 1;
        int[] values = new int[N];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(reader.readLine());
            values[i]= num;
        }

        for (int i = 0; i < N; i++) {
            int value = values[i];
            for (int j = value; j <= K; j++) {
                dp[j] += dp[j - value];
            }
        }

        System.out.print(dp[K]);
    }
}