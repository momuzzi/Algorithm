import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        ArrayDeque<Character> stack = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= 'A' && c <= 'Z' || c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (true) {
                    char pop = stack.pop();
                    if (pop == '(') break;
                    sb.append(pop);
                }
            } else if (c == '+' || c == '-') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    char pop = stack.pop();
                    sb.append(pop);
                }

                stack.push(c);
            } else if (c == '*' || c == '/') {
                while (!stack.isEmpty() && stack.peek() != '(' && stack.peek() != '-' && stack.peek() != '+') {
                    char pop = stack.pop();
                    sb.append(pop);
                }

                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.print(sb);
    }
}