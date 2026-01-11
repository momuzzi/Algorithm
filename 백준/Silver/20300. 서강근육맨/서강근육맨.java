import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        if (N == 1) {
            System.out.print(arr[0]);
            return;
        }

        Arrays.sort(arr);

        int left = 0;
        int right = N % 2 == 0 ? N - 1 : N - 2;
        long max = N % 2 == 0 ? Long.MIN_VALUE : arr[N - 1];

        while (left < right) {
            long sum = arr[left] + arr[right];

            max = Math.max(max, sum);

            left++;
            right--;
        }

        System.out.print(max);
    }
}