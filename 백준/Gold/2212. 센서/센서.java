import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int K;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        init();
        if (K >= N) {
            System.out.print(0);
            return;
        }
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        Arrays.sort(arr);

        int[] dif = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            dif[i] = arr[i + 1] - arr[i];
        }

        Arrays.sort(dif);

        int sum = 0;
        for (int i = 0; i < N - 1 - (K - 1); i++) {
            sum += dif[i];
        }

        System.out.print(sum);
    }
}