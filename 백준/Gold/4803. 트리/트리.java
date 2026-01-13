import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static boolean[][] graph;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 1;
        StringBuilder sb = new StringBuilder();
        while (true) {
            String[] nm = br.readLine().split(" ");
            n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);

            if (n == 0 && m == 0) break;

            graph = new boolean[n + 1][n + 1];
            visit = new boolean[n + 1];

            for (int i = 0; i < m; i++) {
                String[] ab = br.readLine().split(" ");
                int a = Integer.parseInt(ab[0]);
                int b = Integer.parseInt(ab[1]);
                graph[a][b] = graph[b][a]= true;
            }

            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (!visit[i]) {
                    if (dfs(i)) {
                        cnt++;
                    }
                }
            }

            if (cnt == 0) {
                sb.append("Case " + T + ": No trees.");
            } else if (cnt == 1) {
                sb.append("Case " + T + ": There is one tree.");
            } else {
                sb.append("Case " + T + ": A forest of " + cnt + " trees.");
            }

            sb.append("\n");
            T++;
        }

        System.out.print(sb);
    }

    static boolean dfs(int a) {
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[] {a, 0});
        visit[a] = true;

        boolean result = true;
        while (!stack.isEmpty()) {
            int[] pop = stack.pop();

            boolean[] can = graph[pop[0]];

            for (int i = 1; i <= n; i++) {
                if (can[i]) {
                    if (!visit[i]) {
                        visit[i] = true;
                        stack.push(new int[] {i, pop[0]});
                    } else if (i != pop[1]) {
                        result = false;
                    }
                }
            }
        }

        return result;
    }
}