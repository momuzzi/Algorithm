import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int S = Integer.parseInt(s[1]);

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MAX_VALUE;

        int start = 0;
        int end = 0;
        int sum = 0;

        while (end < N) {
            sum += arr[end];
            end++;

            while (sum >= S) {
                answer = Math.min(answer, end - start);
                sum -= arr[start];
                start++;
            }
        }

        if (answer == Integer.MAX_VALUE) {
            System.out.print(0);
            return;
        }

        System.out.print(answer);
    }
}