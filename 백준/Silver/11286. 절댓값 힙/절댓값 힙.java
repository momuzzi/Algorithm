import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        StringBuilder builder = new StringBuilder();

        PriorityQueue<int []> pq = new PriorityQueue<>(new Comparator<int []>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }

                return o1[0] - o2[0];
            }
        });

        for (int i = 1; i <= N; i++) {
            int x = Integer.parseInt(reader.readLine());

            if (x > 0) {
                pq.add(new int[] {x, x}); //[0]절댓값, [1]원본
                continue;
            }

            if (x < 0) {
                pq.add(new int[] {-x, x});
                continue;
            }

            if (x == 0) {
                if (pq.isEmpty()) {
                    builder.append(0).append("\n");
                } else {
                    int[] poll = pq.poll();
                    builder.append(poll[1]).append("\n");
                }
            }
        }

        System.out.print(builder);
    }
}