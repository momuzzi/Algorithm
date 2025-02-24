import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sum = new int[N + 1];
        int answer = 0;
        for (int i = 1; i < N + 1; i++) {
            sum[i] = arr[i];

            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j] && sum[i] < sum[j] + arr[i]) {
                    sum[i] = sum[j] + arr[i];
                }
            }

            answer = Math.max(answer, sum[i]);
        }

        System.out.print(answer);
    }
}