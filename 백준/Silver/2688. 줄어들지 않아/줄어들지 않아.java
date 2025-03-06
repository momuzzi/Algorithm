import java.io.*;

public class Main {

    static BufferedReader br;
    static int T;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
    }

    static void solve() throws Exception {
        long[][] arr;
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            arr = new long[n + 1][10];

            for (int j = 0; j <= 9; j++) {
                arr[1][j] = 1;
            }

            if (n == 1) {
                System.out.println(10);
                continue;
            }

            for (int j = 2; j <= n; j++) {
                for (int k = 0; k <= 9; k++) {
                    for (int l = 0; l <= k; l++) {
                        arr[j][k] += arr[j - 1][l];
                    }
                }
            }

            long sum = 0;
            for (long num : arr[n]) {
                sum += num;
            }

            System.out.println(sum);
        }
    }
}