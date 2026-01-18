import java.io.*;

public class Main {

    static int N, K;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");
        N = Integer.parseInt(NK[0]);
        K = Integer.parseInt(NK[1]);

        arr = new int[N];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        int ans = 0;
        long l = 1;
        long h = max;
        while (l <= h) {
            long m = (l + h) / 2;

            if (can(m)) {
                l = m + 1;
                ans = (int) m;
            } else {
                h = m - 1;
            }
        }

        System.out.print(ans);
    }

    static boolean can(long m) {
        long cnt = 0;

        for (int i = 0; i < N; i++) {
            cnt += arr[i] / m;

            if (cnt >= K) return true;
        }

        return false;
    }
}