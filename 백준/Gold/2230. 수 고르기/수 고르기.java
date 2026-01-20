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

        if (N == 1 && M == 0) {
            System.out.print(0);
            return;
        }

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int minM = Integer.MAX_VALUE;


        int left = 0;
        int right = 1;
        while (right < N) {
            int m = arr[right] - arr[left];

            if (m < M) {
                right++;
            } else if (m == M) {
                System.out.print(M);
                return;
            } else {
                minM = Math.min(minM, m);
                left++;
            }
        }

        System.out.print(minM);
    }
}