import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nmr = br.readLine().split(" ");
        int n = Integer.parseInt(nmr[0]);
        int m = Integer.parseInt(nmr[1]);
        int r = Integer.parseInt(nmr[2]);

        int[] items = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        int[][] graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < r; i++) {
            String[] abl = br.readLine().split(" ");
            int a = Integer.parseInt(abl[0]);
            int b = Integer.parseInt(abl[1]);
            int l = Integer.parseInt(abl[2]);

            graph[a][b] = graph[b][a] = l;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) continue;

                    if (graph[i][k] == Integer.MAX_VALUE || graph[k][j] == Integer.MAX_VALUE) continue;

                    graph[i][j] = Math.min(graph[i][j] , graph[i][k] + graph[k][j]);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int sum = items[i];
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] <= m) {
                    sum += items[j];
                }
            }

            max = Math.max(max, sum);
        }

        System.out.print(max);
    }
}