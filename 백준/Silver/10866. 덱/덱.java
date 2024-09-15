import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        Deque<Integer> dq = new LinkedList<>();

        StringBuilder builder = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");

            String cmd = tokenizer.nextToken();

            if (cmd.equals("push_front")) {
                dq.addFirst(Integer.parseInt(tokenizer.nextToken()));
                continue;
            }

            if (cmd.equals("push_back")) {
                dq.addLast(Integer.parseInt(tokenizer.nextToken()));
                continue;
            }

            if (cmd.equals("pop_front")) {
                if (dq.isEmpty()) {
                    builder.append(-1).append("\n");
                } else {
                    Integer num = dq.pollFirst();
                    builder.append(num).append("\n");
                }
                continue;
            }

            if (cmd.equals("pop_back")) {
                if (dq.isEmpty()) {
                    builder.append(-1).append("\n");
                } else {
                    Integer num = dq.pollLast();
                    builder.append(num).append("\n");
                }
                continue;
            }

            if (cmd.equals("size")) {
                builder.append(dq.size()).append("\n");
                continue;
            }

            if (cmd.equals("empty")) {
                if (dq.isEmpty()) {
                    builder.append(1).append("\n");
                } else {
                    builder.append(0).append("\n");
                }
                continue;
            }

            if (cmd.equals("front")) {
                if (dq.isEmpty()) {
                    builder.append(-1).append("\n");
                } else {
                    builder.append(dq.peekFirst()).append("\n");
                }
                continue;
            }

            if (cmd.equals("back")) {
                if (dq.isEmpty()) {
                    builder.append(-1).append("\n");
                } else {
                    builder.append(dq.peekLast()).append("\n");
                }
            }
        }

        System.out.print(builder);
    }
}