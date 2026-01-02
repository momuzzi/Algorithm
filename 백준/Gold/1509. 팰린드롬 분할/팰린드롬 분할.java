import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (isPelin(s, j, i - 1)) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        System.out.print(dp[s.length()]);
    }

    static boolean isPelin(String s, int start, int end) {
        int left = start;
        int right = end;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;

            left++;
            right--;
        }

        return true;
    }
}