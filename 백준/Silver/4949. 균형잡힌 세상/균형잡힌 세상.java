import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder builder = new StringBuilder();

        while (true) {
            String str = reader.readLine();

            if (str.equals(".")) {
                break;
            }

            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.empty()) {
                        builder.append("no").append("\n");
                        break;
                    } else if (stack.peek() != '(') {
                        builder.append("no").append("\n");
                        break;
                    } else {
                        stack.pop();
                    }
                } else if (c == ']') {
                    if (stack.empty()) {
                        builder.append("no").append("\n");
                        break;
                    } else if (stack.peek() != '[') {
                        builder.append("no").append("\n");
                        break;
                    } else {
                        stack.pop();
                    }
                } else if (c == '.') {
                    if (stack.empty()) {
                        builder.append("yes").append("\n");
                    } else {
                        builder.append("no").append("\n");
                    }
                }
            }
        }
        System.out.println(builder);
    }
}