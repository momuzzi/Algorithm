import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> min = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            int n = Integer.parseInt(br.readLine());

            max.offer(n);
            min.offer(max.poll());

            if (min.size() > max.size()) {
                max.offer(min.poll());
            }

            sb.append(max.peek() + "\n");
        }

        System.out.print(sb);
    }
}