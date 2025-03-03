import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int m;
    static PriorityQueue<Long> pq = new PriorityQueue<>();

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(st.nextToken());
            pq.offer(num);
        }
    }

    static void solve() {
        for (int i = 0; i < m; i++) {
            long pollA = pq.poll();
            long pollB = pq.poll();

            pollA += pollB;
            pollB = pollA;

            pq.offer(pollA);
            pq.offer(pollB);
        }

        long sum = 0l;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }

        System.out.print(sum);
    }

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }
}