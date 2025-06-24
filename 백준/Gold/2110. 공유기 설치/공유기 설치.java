import java.io.*;
import java.util.*;

public class Main {

    static int N, C;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nc = br.readLine().split(" ");
        N = Integer.parseInt(nc[0]);
        C = Integer.parseInt(nc[1]);

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
    }

    static void solve() {
        int l = 1;
        int u = arr[N - 1] - arr[0];
        int answer = 0;
        
        while (l <= u) {
            int m = (l + u) / 2;

            if (canInstall(m)) {
                answer = Math.max(answer, m);
                l = m + 1;
            } else {
                u = m - 1;
            }
        }

        System.out.print(answer);
    }

    static boolean canInstall(int d) {
        int cnt = 1;
        int beforeHouse = arr[0];

        for (int i = 1; i < N; i++) {
            if (arr[i] - beforeHouse >= d) {
                cnt++;
                beforeHouse = arr[i];
            }
        }

        return cnt >= C;
    }
}