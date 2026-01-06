import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayDeque<int[]> dq = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            dq.offer(new int[] {i, Integer.parseInt(st.nextToken())});
        }

        StringBuilder sb = new StringBuilder();

        int how = dq.pollFirst()[1];
        sb.append(1 + " ");
        while (!dq.isEmpty()) {
            int[] poll;
            if (how > 0) {
                for (int i = 0; i < how - 1; i++) {
                    dq.offerLast(dq.pollFirst());
                }

                poll = dq.pollFirst();
            } else {
                for (int i = 0; i < Math.abs(how) - 1; i++) {
                    dq.offerFirst(dq.pollLast());
                }

                poll = dq.pollLast();
            }

            how = poll[1];
            sb.append(poll[0] + " ");
        }

        System.out.print(sb);
    }
}