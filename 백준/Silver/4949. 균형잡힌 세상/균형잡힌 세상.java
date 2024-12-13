import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            Deque<Character> stack = new ArrayDeque<>();

            String input = rd.readLine();

            if (input.equals(".")) {
                break;
            }

            char[] arr = input.toCharArray();

            for (char c : arr) {
                if (c == '(' || c == '[') {
                    stack.addLast(c);
                    continue;
                }

                if (c == ')') {
                    if (stack.isEmpty()) {
                        sb.append("no" + "\n");
                        break;
                    } else {
                        Character pop = stack.pollLast();
                        if (!pop.equals('(')) {
                            sb.append("no" + "\n");
                            break;
                        }
                    }
                    continue;
                }

                if (c == ']') {
                    if (stack.isEmpty()) {
                        sb.append("no" + "\n");
                        break;
                    } else {
                        Character pop = stack.pollLast();
                        if (!pop.equals('[')) {
                            sb.append("no" + "\n");
                            break;
                        }
                    }
                    continue;
                }

                if (c == '.') {
                    if (!stack.isEmpty()) {
                        sb.append("no" + "\n");
                    } else {
                        sb.append("yes" + "\n");
                    }
                }
            }
        }

        System.out.print(sb);
    }
}