import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        String str = reader.readLine();

        Stack<Character> stack = new Stack<>();

        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {
            if (String.valueOf(str.charAt(i)).equals("<")) {
                flag = true;

                while (!stack.isEmpty()) {
                    builder.append(stack.pop());
                }

                builder.append("<");
                continue;
            }

            if (String.valueOf(str.charAt(i)).equals(">")) {
                flag = false;

                builder.append(">");
                continue;
            }

            if (String.valueOf(str.charAt(i)).equals(" ") && !flag) {
                while (!stack.isEmpty()) {
                    builder.append(stack.pop());
                }
                builder.append(" ");
                continue;
            }

            if (flag) {
                builder.append(str.charAt(i));
                continue;
            } else {
                stack.push(str.charAt(i));
            }
        }

        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }

        System.out.print(builder);
    }
}