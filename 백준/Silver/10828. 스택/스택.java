import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();

        int N = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            String cmd = tokenizer.nextToken();

            if (cmd.equals("push")) {
                int num = Integer.parseInt(tokenizer.nextToken());
                stack.push(num);
                continue;
            }

            if (cmd.equals("pop")) {
                if (stack.empty()) {
                    builder.append(-1).append("\n");
                    continue;
                }
                Integer popNum = stack.pop();
                builder.append(popNum).append("\n");
                continue;
            }

            if (cmd.equals("size")) {
                builder.append(stack.size()).append("\n");
                continue;
            }

            if (cmd.equals("empty")) {
                if (stack.empty()) {
                    builder.append(1).append("\n");
                    continue;
                }
                builder.append(0).append("\n");
                continue;
            }

            if (cmd.equals("top")) {
                if (stack.empty()) {
                    builder.append(-1).append("\n");
                    continue;
                }
                builder.append(stack.peek()).append("\n");
            }
        }

        System.out.print(builder);
    }
}