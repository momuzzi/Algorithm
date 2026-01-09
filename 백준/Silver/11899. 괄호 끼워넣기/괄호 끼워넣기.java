import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        ArrayDeque<Character> stack = new ArrayDeque<>();

        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    cnt++;
                } else {
                    stack.pop();
                }
            }
        }

        System.out.print(cnt + stack.size());
    }
}