import java.io.*;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    }

    static void solve() {
        int[] dp = new int[N + 1];
        arr = new int[N + 1];

        for (int i = 2; i <= N; i++) {
            int how = 1;
            int min = dp[i - 1];

            if (i >= 2 && i % 2 == 0) {
                if (dp[i / 2] < min) {
                    how = 2;
                    min = dp[i / 2];
                }
            }

            if (i >= 3 && i % 3 == 0) {
                if (dp[i / 3] < min) {
                    how = 3;
                    min = dp[i / 3];
                }
            }

            saveBeforeNum(i, how);

            dp[i] = min + 1;
        }

        System.out.println(dp[N]);

        System.out.print(N + " ");
        int num = arr[N];
        for (int i = 0; i < dp[N]; i++) {
            System.out.print(num + " ");
            num = arr[num];
        }
    }

    static void saveBeforeNum(int num, int how) {
        if (how == 1) {
            arr[num] = num - 1;
        }

        if (how == 2) {
            arr[num] = num / 2;
        }

        if (how == 3) {
            arr[num] = num / 3;
        }
    }
}