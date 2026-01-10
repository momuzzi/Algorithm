import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        Arrays.fill(arr, -1);

        ArrayDeque<int[]> stack = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek()[1] < n) {
                int[] pop = stack.pop();
                arr[pop[0]] = n;
            }

            stack.push(new int[] {i, n});
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i] + " ");
        }

        System.out.print(sb);
    }
}