import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());

        StringBuilder builder = new StringBuilder();

        for (int i = 1; i <= T; i++) {
            String str = reader.readLine();
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c == '(') {
                    stack.push(c);

                    if (j == str.length() - 1) {
                        builder.append("NO").append("\n");
                        break;
                    }

                    continue;
                }

                if (c == ')') {
                    if (stack.empty()) {
                        builder.append("NO").append("\n");
                        break;
                    } else {
                        stack.pop();
                        if (j == str.length() - 1) {
                            if (stack.empty()) {
                                builder.append("YES").append("\n");
                            } else {
                                builder.append("NO").append("\n");
                            }
                        }
                    }
                }
            }
        }

        System.out.print(builder.toString());
    }
}