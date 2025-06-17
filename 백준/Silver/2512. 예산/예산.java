import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    static int M;
    static int max = Integer.MIN_VALUE;
    static int allSum = 0;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            allSum += arr[i];

            if (arr[i] > max) {
                max = arr[i];
            }
        }

        M = Integer.parseInt(br.readLine());
    }

    static void solve() {
        if (allSum <= M) {
            System.out.print(max);
            return;
        }

        int l = 1;
        int u = max;

        int answer = 0;

        while (l <= u) {
            int m = (l + u) / 2;

            int sum = 0;
            for (int num : arr) {
                sum += Math.min(num, m);
            }

            if (sum <= M) {
                answer = m;
                l = m + 1;
            }

            if (sum > M) {
                u = m - 1;
            }
        }

        System.out.print(answer);
    }
}