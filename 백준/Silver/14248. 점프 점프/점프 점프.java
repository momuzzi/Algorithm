import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] arr;
    static boolean[] visit;
    static int s;
    static int[] dx = {-1, 1};

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        visit = new boolean[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        s = Integer.parseInt(br.readLine());
    }

    static void solve() {
        LinkedList<Integer> q = new LinkedList<>();
        q.offerLast(s);
        visit[s] = true;

        while (!q.isEmpty()) {
            int now = q.pollFirst();

            for (int i = 0 ; i < 2; i++) {
                int move = now + (arr[now] * dx[i]);

                if (move <= 0 || move > n) continue;
                if (!visit[move]) {
                    visit[move] = true;
                    q.offerLast(move);
                }
            }
        }

        int cnt = 0;
        for (boolean bool : visit) {
            if (bool) cnt++;
        }

        System.out.print(cnt);
    }
}