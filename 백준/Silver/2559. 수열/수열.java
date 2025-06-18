import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int K;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ip = br.readLine().split(" ");
        N = Integer.parseInt(ip[0]);
        K = Integer.parseInt(ip[1]);
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
    static void solve() {
        int max = 0;
        for (int i = 0; i < K; i++) {
            max += arr[i];
        }

        int start = 0;
        int end = K - 1;

        int now = max;
        while (end < N - 1) {
            now -= arr[start];
            now += arr[end + 1];
            max = Math.max(max, now);

            start++;
            end++;
        }

        System.out.print(max);
    }
}