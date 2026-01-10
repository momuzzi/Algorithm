import java.io.*;

public class Main {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        int max = Integer.MIN_VALUE;
        arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        int ans = 0;
        int l = 1;
        int h = max;
        while (l <= h) {
            int m = (l + h) / 2;

            if (can(m)) {
                h = m - 1;
                ans = m;
            } else {
                l = m + 1;
            }
        }

        System.out.print(ans);
    }

    static boolean can(int m) {
        long sum = 0;

        for (int i = 0; i < M; i++) {
            int n = arr[i];

            sum += n / m;

            if (n % m != 0) sum++;
        }

        return sum <= N;
    }
}