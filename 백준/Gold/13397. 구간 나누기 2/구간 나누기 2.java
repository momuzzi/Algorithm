import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        StringTokenizer st = new StringTokenizer(br.readLine());

        int min =Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        int ans = 0;
        int l = 0;
        int h = max - min;
        while (l <= h) {
            int m = (l + h) / 2;

            if (can(m)) {
                ans = m;
                h = m - 1;
            } else {
                l = m + 1;
            }
        }

        System.out.print(ans);
    }

    static boolean can(int limit) {
        int cnt = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < N; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);

            if (max - min > limit) {
                min = arr[i];
                max = arr[i];
                cnt++;
            }
        }

        return cnt < M;
    }
}