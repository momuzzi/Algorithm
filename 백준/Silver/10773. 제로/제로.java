import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int K = Integer.parseInt(reader.readLine());
        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(reader.readLine());

            if (num == 0) {
                stack.pop();
                continue;
            }
            stack.push(num);
        }

        int answer = 0;
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }
        System.out.print(answer);
    }
}