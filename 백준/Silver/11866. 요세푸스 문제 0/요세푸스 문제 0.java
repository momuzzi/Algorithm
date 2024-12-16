import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        Deque<Integer> q = new ArrayDeque<>();

        int num = 1;
        while (num != n + 1) {
            q.addLast(num);
            num++;
        }
        sb.append("<");
        while (true) {
            for (int i = 0; i < k - 1; i++) {
                Integer poll = q.pollFirst();
                q.addLast(poll);
            }
            Integer printNum = q.pollFirst();
            if (q.isEmpty()) {
                sb.append(printNum + ">");
                break;
            }
            sb.append(printNum + ", ");
        }

        System.out.print(sb);
    }
}