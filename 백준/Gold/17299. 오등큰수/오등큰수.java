import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int[] ans = new int[N];

        for (int i = 0; i < N; i++) {

            while (!stack.isEmpty() && map.get(arr[stack.peek()]) < map.get(arr[i])) {
                int idx = stack.pop();

                ans[idx] = arr[i];
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int idx = stack.pop();

            ans[idx] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : ans) {
            sb.append(i + " ");
        }

        System.out.print(sb);
    }
}