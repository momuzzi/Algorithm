import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + arr[i - 1];
        }

        int max = Integer.MIN_VALUE;

        for (int i = 2; i <= N - 1; i++) {
            int a = sum[N] - sum[1] - arr[i - 1];
            int b = sum[N] - sum[i];

            max = Math.max(max, a + b);
        }

        for (int i = 2; i <= N - 1; i++) {
            int a = sum[i] - sum[1];
            int b = sum[N - 1] - sum[i - 1];

            max = Math.max(max, a + b);
        }

        for (int i = 2; i <= N - 1; i++) {
            int a = sum[N - 1] - arr[i - 1];
            int b = sum[i - 1];

            max = Math.max(max, a + b);
        }

        System.out.print(max);
    }
}