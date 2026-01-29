import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            String[] start = br.readLine().split(" ");

            int startX = Integer.parseInt(start[0]);
            int startY = Integer.parseInt(start[1]);

            int[][] graph = new int[n + 2][2];
            graph[0][0] = startX;
            graph[0][1] = startY;

            boolean[] visit = new boolean[n + 2];
            visit[0] = true;

            for (int j = 1; j <= n; j++) {
                String[] xy = br.readLine().split(" ");
                graph[j][0] = Integer.parseInt(xy[0]);
                graph[j][1] = Integer.parseInt(xy[1]);
            }

            String[] end = br.readLine().split(" ");

            graph[n + 1][0] = Integer.parseInt(end[0]);
            graph[n + 1][1] = Integer.parseInt(end[1]);

            ArrayDeque<Integer> q = new ArrayDeque<>();
            q.offer(0);

            boolean can = false;
            while (!q.isEmpty()) {
                int now = q.poll();

                for (int j = 0; j < n + 2; j++) {
                    if (now == j) continue;

                    if (visit[j]) continue;

                    int nowX = graph[now][0];
                    int nowY = graph[now][1];

                    int nextX = graph[j][0];
                    int nextY = graph[j][1];

                    int dist = Math.abs(nowX - nextX) + Math.abs(nowY - nextY);

                    if (dist <= 1000) {
                        if (j == n + 1) {
                            can = true;
                            break;
                        }

                        visit[j] = true;
                        q.offer(j);
                    }
                }
            }

            sb.append(can ? "happy" : "sad").append("\n");
        }

        System.out.print(sb);
    }
}