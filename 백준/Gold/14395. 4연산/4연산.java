import java.io.*;
import java.util.*;

public class Main {

    static Set<Long> visit = new HashSet<>();
    static Map<Long, Character> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        long s = Long.parseLong(st[0]);
        long t = Long.parseLong(st[1]);

        if (s == t) {
            System.out.print(0);
            return;
        }

        ArrayDeque<Long> q = new ArrayDeque<>();
        q.offer(s);
        visit.add(s);

        while (!q.isEmpty()) {
            long poll = q.poll();
            if (poll == t) break;

            for (int i = 0; i < 4; i++) {
                char c;
                long next;
                if (i == 0) {
                    c = '*';
                    next = poll * poll;

                } else if (i == 1) {
                    c = '+';
                    next = poll + poll;
                } else if (i == 2) {
                    c = '-';
                    next = poll - poll;
                } else {
                    c = '/';
                    if (poll == 0) continue;
                    next = poll / poll;
                }

                if (!visit.contains(next)) {
                    visit.add(next);
                    map.put(next, c);
                    q.offer(next);
                }
            }
        }

        if (!visit.contains(t)) {
            System.out.print(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        long now = t;
        while (true) {
            char c = map.get(now);

            sb.append(c);

            if (c == '/' || c == '-') break;

            if (c == '+') {
                now /= 2;
            }

            if (c == '*') {
                now = (long) Math.sqrt(now);
            }

            if (now == s) break;
        }

        System.out.print(sb.reverse());
    }
}