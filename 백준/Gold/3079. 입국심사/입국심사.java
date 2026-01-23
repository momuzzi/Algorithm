import java.io.*;

public class Main {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        arr = new int[N];

        long max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long ans = 0;
        long l = 1;
        long h = max * M;
        while (l <= h) {
            long m = (l + h) / 2;

            if (can(m)) {
                h = m - 1;
                ans = m;
            } else {
                l = m + 1;
            }
        }

        System.out.print(ans);
    }

    static boolean can(long m) {
        long cnt = 0;

        for (int i = 0; i < N; i++) {
            cnt += m / arr[i];
            
            if (cnt >= M) return true;
        }

        return false;
    }
}