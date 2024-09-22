import java.io.*;
import java.util.*;

public class Main {

    static HashSet<Long> visited;
    static LinkedList<long[]> q;
    static long A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        A = Long.parseLong(s[0]);
        B = Long.parseLong(s[1]);

        visited = new HashSet<>();

        long result = bfs(A);

        System.out.print(result);
    }

    static long bfs(long location) {
        q = new LinkedList<>();
        q.add(new long[] {location, 1});

        while (!q.isEmpty()) {
            long[] poll = q.poll();
            long thisLocation = poll[0];
            long cnt = poll[1];

            if (thisLocation == B) {
                return cnt;
            }

            if (thisLocation * 2 <= B && !visited.contains(thisLocation * 2)) {
                visited.add(thisLocation * 2);
                q.add(new long[] {thisLocation * 2, cnt + 1});
            }

            String str = thisLocation + "1";
            if (Long.parseLong(str) <= B && !visited.contains(Long.parseLong(str))) {
                visited.add(Long.parseLong(str));
                q.add(new long[] {Long.parseLong(str), cnt + 1});
            }
        }

        return -1;
    }
}