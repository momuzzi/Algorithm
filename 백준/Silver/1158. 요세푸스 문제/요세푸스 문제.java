import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> q = new LinkedList<>();
        StringBuilder builder = new StringBuilder();

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        builder.append("<");
        while (!q.isEmpty()) {
            for (int i = 1; i <= m; i++) {
                if (i == m && q.size() == 1) {
                    builder.append(q.poll()).append(">");
                    break;
                }

                if (i == m) {
                    builder.append(q.poll()).append(", ");
                    break;
                }
                Integer pollNum = q.poll();
                q.add(pollNum);
            }
        }

        System.out.print(builder);
    }
}