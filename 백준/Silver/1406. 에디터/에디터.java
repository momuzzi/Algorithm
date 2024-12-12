import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = rd.readLine();

        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();

        char[] arr = str.toCharArray();

        for (char c : arr) {
            left.addLast(c);
        }

        int M = Integer.parseInt(rd.readLine());

        for (int i = 0; i < M; i++) {
            String cmd = rd.readLine();

            if (cmd.startsWith("P")) {
                char c = cmd.charAt(2);
                left.addLast(c);
                continue;
            }

            if (cmd.equals("L")) {
                if (!left.isEmpty()) {
                    Character pop = left.pollLast();
                    right.addFirst(pop);
                }
                continue;
            }

            if (cmd.equals("D")) {
                if (!right.isEmpty()) {
                    Character pop = right.pollFirst();
                    left.addLast(pop);
                }
                continue;
            }

            if (cmd.equals("B")) {
                if (!left.isEmpty()) {
                    left.pollLast();
                }
            }
        }

        while (!left.isEmpty()) {
            sb.append(left.pollFirst());
        }

        while (!right.isEmpty()) {
            sb.append(right.pollFirst());
        }

        System.out.print(sb);
    }
}