import java.io.*;

public class Main {

    static int N;
    static int K;
    static int[] W;
    static int[] V;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);
        
        W = new int[N + 1];
        V = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            String[] ss = br.readLine().split(" ");
            W[i] = Integer.parseInt(ss[0]);
            V[i] = Integer.parseInt(ss[1]);
        }

        dp = new int[N + 1][K + 1];
    }

    static void solve() {
        for (int i = 1; i <= N; i++) { // i번째 물건을 넣으려할 때
            for (int j = 0; j <= K; j++) { // 무게 j를 초과하지 않는
                dp[i][j] = dp[i - 1][j];

                if (j >= W[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - W[i]] + V[i]);
                }
            }
        }

        System.out.print(dp[N][K]);
    }
}