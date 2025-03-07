import java.io.*;

public class Main {

    static BufferedReader br;
    static int T;
    static long[][] arr;
    static int MOD = 1_000_000_009;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
    }

    static void solve() throws Exception {
        calculate();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            long sum = (arr[n][1] + arr[n][2] + arr[n][3]) % MOD;
            sb.append(sum).append("\n");
        }

        System.out.print(sb);
    }

    static void calculate() {
        arr = new long[100001][4];

        arr[1][1] = 1;
        arr[2][2] = 1;
        arr[3][1] = 1;
        arr[3][2] = 1;
        arr[3][3] = 1;

        for (int j = 4; j <= 100000; j++) {
            arr[j][1] = (arr[j - 1][2] + arr[j - 1][3]) % MOD;
            arr[j][2] = (arr[j - 2][1] + arr[j - 2][3]) % MOD;
            arr[j][3] = (arr[j - 3][1] + arr[j - 3][2]) % MOD;
        }
    }
}
