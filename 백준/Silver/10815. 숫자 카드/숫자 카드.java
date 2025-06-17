import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] sArr;

    static int M;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        init();
        StringBuilder sb = new StringBuilder();
        for (int n : arr) {
            sb.append(solve(n) + " ");
        }

        System.out.print(sb);
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        sArr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sArr);

        M = Integer.parseInt(br.readLine());
        arr = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static int solve(int target) {
        int l = 0;
        int u = sArr.length;

        while (l < u) {
            int m = (l + u) / 2;

            if (target < sArr[m]) {
                u = m;
            }

            if (target > sArr[m]) {
                l = m + 1;
            }

            if (target == sArr[m]) {
                return 1;
            }
        }

        return 0;
    }
}