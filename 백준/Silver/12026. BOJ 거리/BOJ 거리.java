import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            char next = getNext(s.charAt(i));
            if (dp[i] == Integer.MAX_VALUE) continue;
            for (int j = i + 1; j < N; j++) {
                if (s.charAt(j) == next) {
                    int d = j - i;
                    dp[j] = Math.min(dp[j], dp[i] + d * d);
                }
            }
        }

        System.out.print(dp[N - 1] == Integer.MAX_VALUE ? -1 : dp[N - 1]);
    }

    static char getNext(char c) {
        if (c == 'B') return 'O';

        if (c == 'O') return 'J';

        return 'B';
    }
}