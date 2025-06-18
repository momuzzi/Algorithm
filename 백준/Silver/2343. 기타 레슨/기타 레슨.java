import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[] arr;
    static int maxNum = Integer.MIN_VALUE;
    static int allSum = 0;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            allSum += arr[i];

            maxNum = Math.max(maxNum, arr[i]);
        }
    }
    static void solve() {
        int l = maxNum;
        int u = allSum;
        int answer = Integer.MAX_VALUE;

        while (l <= u) {
            int m = (l + u) / 2;

            int cnt = 1;
            int partSum = 0;
            for (int num : arr) {
                if (partSum + num > m) {
                    cnt++;
                    partSum = 0;
                }
                partSum += num;
            }

            if (cnt <= M) {
                answer = Math.min(answer, m);
                u = m - 1;
            }

            if (cnt > M) {
                l = m + 1;
            }
        }

        System.out.print(answer);
    }
}