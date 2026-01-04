import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> right = new PriorityQueue<>((a, b) -> b - a);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());

            if (n > 0) {
                right.offer(n);
            } else {
                left.offer(Math.abs(n));
            }
        }

        int sum = 0;
        if (right.isEmpty() || !left.isEmpty() && left.peek() >= right.peek()) {
            sum += left.peek();
            for (int i = 0; i < M; i++) {
                if (!left.isEmpty()) {
                    left.poll();
                } else
                    break;
            }
        } else if (left.isEmpty() || !right.isEmpty() && left.peek() < right.peek()) {
            sum += right.peek();
            for (int i = 0; i < M; i++) {
                if (!right.isEmpty()) {
                    right.poll();
                } else
                    break;
            }
        }

        while (!left.isEmpty()) {
            sum += left.peek() * 2;
            for (int i = 0; i < M; i++) {
                if (!left.isEmpty()) {
                    left.poll();
                } else break;
            }
        }

        while (!right.isEmpty()) {
            sum += right.peek() * 2;
            for (int i = 0; i < M; i++) {
                if (!right.isEmpty()) {
                    right.poll();
                } else break;
            }
        }

        System.out.print(sum);
    }
}