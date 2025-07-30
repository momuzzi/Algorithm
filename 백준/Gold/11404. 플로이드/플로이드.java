import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[][] graph;
    static int MAX = 100_000 * 99 + 1;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], MAX);
        }

        for (int i = 1; i <= n; i++) {
            graph[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int need = Integer.parseInt(st.nextToken());

            graph[from][to] = Math.min(graph[from][to], need);
        }
    }

    static void solve() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            int[] arr = graph[i];
            for (int j = 1; j <= n; j++) {
                int num = arr[j];
                if (num == MAX) {
                    num = 0;
                }
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}