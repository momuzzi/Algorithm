import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S =  br.readLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            if (c == ')') {
                int length = 0;
                while (true) {
                    int pop = stack.pop();
                    if (pop == -1) break;

                    length += pop;
                }

                int cnt = stack.pop();

                stack.push(cnt * length);

            } else if (Character.isDigit(c)){
                if (i != S.length() - 1 && S.charAt(i + 1) == '(') {
                    stack.push(c - '0');
                } else {
                    stack.push(1);
                }
            } else {
                stack.push(-1);
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        System.out.print(sum);
    }
}