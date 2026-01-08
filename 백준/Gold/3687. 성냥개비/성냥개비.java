import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        String[] arr = new String[8];
        arr[2] = "1";
        arr[3] = "7";
        arr[4] = "4";
        arr[5] = "2";
        arr[6] = "0";
        arr[7] = "8";
        
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());

            String[] dp = new String[n + 1];

            dp[2] = "1";
            if (n >= 3) dp[3] = "7";
            if (n >= 4) dp[4] = "4";
            if (n >= 5) dp[5] = "2";
            if (n >= 6) dp[6] = "6";
            if (n >= 7) dp[7] = "8";

            for (int j = 8; j <= n; j++) {
                String minS = dp[j - 2] + arr[2];
                for (int k = 3; k < 8; k++) {
                    minS = min(minS, dp[j - k] + arr[k]);
                }

                dp[j] = minS;
            }

            sb.append(dp[n] + " ");

            int oneCnt = n / 2;
            int sevenCnt = n % 2;

            if (sevenCnt == 1) {
                oneCnt--;
                sb.append(7);
            }

            for (int j = 0; j < oneCnt; j++) {
                sb.append(1);
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }

    static String min(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return s1.length() > s2.length() ? s2 : s1;
        }

        return s1.compareTo(s2) < 0 ? s1 : s2;
    }
}