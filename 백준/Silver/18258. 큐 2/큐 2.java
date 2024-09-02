import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        Deque<Integer> q = new LinkedList<>();

        int num = Integer.parseInt(reader.readLine());

        for (int i = 0; i < num; i++) {
            String input = reader.readLine();
            String[] command = input.split(" ");

            if (command[0].equals("push")) {
                q.add(Integer.parseInt(command[1]));
            }

            if (command[0].equals("pop")) {
                if (q.peek() != null) {
                    Integer result = q.pop();
                    builder.append(result).append("\n");
                } else {
                    builder.append(-1).append("\n");
                }
            }

            if (command[0].equals("size")) {
                int size = q.size();
                builder.append(size).append("\n");
            }

            if (command[0].equals("empty")) {
                if (q.isEmpty()) {
                    builder.append(1).append("\n");
                } else {
                    builder.append(0).append("\n");
                }
            }

            if (command[0].equals("front")) {
                Integer result = q.peek();
                if (result != null) {
                    builder.append(result).append("\n");
                } else {
                    builder.append(-1).append("\n");
                }
            }

            if (command[0].equals("back")) {
                Integer result = q.peekLast();
                if (result != null) {
                    builder.append(result).append("\n");
                } else {
                    builder.append(-1).append("\n");
                }
            }
        }

        System.out.println(builder);
    }
}