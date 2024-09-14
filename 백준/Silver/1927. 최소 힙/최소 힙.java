import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        StringBuilder builder = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            int x = Integer.parseInt(reader.readLine());

            if (x != 0) {
                pq.add(x);
            } else {
                if (pq.isEmpty()) {
                    builder.append(0).append("\n");
                } else {
                    builder.append(pq.poll()).append("\n");
                }
            }
        }


        System.out.print(builder);
    }
}