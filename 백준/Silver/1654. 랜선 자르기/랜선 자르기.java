import java.io.*;
import java.util.*;

public class Main {

    static int K;
    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        K = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);

        arr = new int[K];

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
    }

    static void solve() {
        long l = 1;
        long u = arr[K - 1];

        long answer = 0;

        while (l <= u) {
            long m = (l + u) / 2;

            int cnt = 0;
            for (int num : arr) {
                cnt += (num / m);
            }

            if (cnt < N) {
                u = m - 1;
            }

            if (cnt >= N) {
                answer = Math.max(answer, m);
                l = m + 1;
            }
        }

        System.out.print(answer);
    }
}