import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0 ; i < N; i++) {
            int num = Integer.parseInt(reader.readLine());
            pq.add(num);
        }

        int answer = 0;
        while (pq.size() != 1) {
            Integer first = pq.poll();
            Integer second = pq.poll();
            answer += first + second;
            pq.add(first + second);

        }

        System.out.print(answer);
    }
}