import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    static boolean[] res;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int allSum = 0;
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            allSum += arr[i];
        }

        res = new boolean[allSum + 1];
        re(0, 0);

        for (int i = 1; i < res.length; i++) {
            if (!res[i]) {
                System.out.print(i);
                return;
            }
        }

        System.out.print(allSum + 1);
    }

    static void re(int depth, int sum) {
        if (depth == N) {
            res[sum] = true;
            return;
        }

        re(depth + 1, sum + arr[depth]);
        re(depth + 1, sum);
    }
}