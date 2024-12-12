import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = rd.readLine();

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        char[] arr = str.toCharArray();

        for (char c : arr) {
            left.push(c);
        }

        int M = Integer.parseInt(rd.readLine());

        for (int i = 0; i < M; i++) {
            String cmd = rd.readLine();

            if (cmd.startsWith("P")) {
                char c = cmd.charAt(2);
                left.push(c);
                continue;
            }

            if (cmd.equals("L")) {
                if (!left.empty()) {
                    Character pop = left.pop();
                    right.push(pop);
                }
                continue;
            }

            if (cmd.equals("D")) {
                if (!right.empty()) {
                    Character pop = right.pop();
                    left.push(pop);
                }
                continue;
            }

            if (cmd.equals("B")) {
                if (!left.empty()) {
                    left.pop();
                }
            }
        }

        while (!left.empty()) {
            Character pop = left.pop();
            right.push(pop);
        }

        while (!right.empty()) {
            Character pop = right.pop();
            sb.append(pop);
        }

        System.out.print(sb);
    }
}