import java.io.*;
import java.util.*;

public class Main {

    static int C;
    static int N;
    static int[] money;
    static int[] people;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        C = Integer.parseInt(s[0]);
        N = Integer.parseInt(s[1]);

        money = new int[N + 1];
        people = new int[N + 1];

        dp = new int[C + 100]; // +99명
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            String[] ss = br.readLine().split(" ");
            money[i] = Integer.parseInt(ss[0]);
            people[i] = Integer.parseInt(ss[1]);
        }
    }

    static void solve() {
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = people[i]; j <= C + 99; j++) {
                if (dp[j - people[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - people[i]] + money[i]);
                }

                if (j >= C) {
                    answer = Math.min(answer, dp[j]);
                }
            }
        }

        System.out.print(answer);
    }
}