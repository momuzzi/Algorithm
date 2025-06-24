import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<Integer>[] g;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        g = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            g[B].add(A);
        }
    }
    
    static void solve() {
        int[] result = new int[N + 1];
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            visit = new boolean[N + 1];
            result[i] = dfs(i);
            max = Math.max(max, result[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (result[i] == max) {
                sb.append(i).append(" ");
            }
        }

        System.out.print(sb);
    }

    static int dfs(int start) {
        int cnt = 1;
        LinkedList<Integer> s = new LinkedList<>();
        s.offerLast(start);
        visit[start] = true;

        while (!s.isEmpty()) {
            int now = s.pollLast();

            for (int next : g[now]) {
                if (!visit[next]) {
                    visit[next] = true;
                    s.offerLast(next);
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
