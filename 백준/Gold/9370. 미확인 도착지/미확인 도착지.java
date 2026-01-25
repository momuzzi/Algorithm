import java.io.*;
import java.util.*;

public class Main {

    static int n, s;
    static List<List<int[]>> graph;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String[] nmt = br.readLine().split(" ");
            n = Integer.parseInt(nmt[0]);
            int m = Integer.parseInt(nmt[1]);
            int t = Integer.parseInt(nmt[2]);

            String[] sgh = br.readLine().split(" ");
            s = Integer.parseInt(sgh[0]);
            int g = Integer.parseInt(sgh[1]);
            int h = Integer.parseInt(sgh[2]);

            graph = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                graph.add(new ArrayList<>());
            }

            int gToH = 0;
            for (int j = 0; j < m; j++) {
                String[] abd = br.readLine().split(" ");
                int a = Integer.parseInt(abd[0]);
                int b = Integer.parseInt(abd[1]);
                int d = Integer.parseInt(abd[2]);

                if (a == g && b == h || a == h && b == g) {
                    gToH = d;
                }

                graph.get(a).add(new int[] {b, d});
                graph.get(b).add(new int[] {a, d});
            }

            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < t; j++) {
                int x = Integer.parseInt(br.readLine());

                dijk(s);
                int sToX = dist[x];
                int sToG = dist[g];
                int sToH = dist[h];

                if (sToX == Integer.MAX_VALUE || sToG == Integer.MAX_VALUE || sToH == Integer.MAX_VALUE) continue;

                dijk(x);
                int xToG = dist[g];
                int xToH = dist[h];

                if (xToG == Integer.MAX_VALUE || xToH == Integer.MAX_VALUE) continue;

                int sghx = sToG + gToH + xToH;
                int shgx = sToH + gToH + xToG;

                if (sToX == sghx || sToX == shgx) {
                    list.add(x);
                }
            }

            Collections.sort(list);

            for (int num : list) {
                sb.append(num + " ");
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void dijk(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] {start, 0});
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();

            List<int[]> nexts = graph.get(poll[0]);

            for (int[] next : nexts) {
                if (dist[next[0]] > poll[1] + next[1]) {
                    dist[next[0]] = poll[1] + next[1];
                    pq.offer(new int[] {next[0], dist[next[0]]});
                }
            }
        }
    }
}