import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static boolean[][] graph;
    static int[][] dist;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        graph = new boolean[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            for (int j = 0; j < M; j++) {
                graph[i][j] = st.nextToken().equals("0") ? true : false;
                if (!graph[i][j]) dist[i][j] = 0;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!graph[i][j]) {
                    bfs(i, j);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                max = Math.max(max, dist[i][j]);
            }
        }

        System.out.print(max);
    }

    static void bfs(int a, int b) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {a, b});

        while (!q.isEmpty()) {
            int[] poll = q.poll();

            for (int i = 0; i < 8; i++) {
                int x = poll[0] + dx[i];
                int y = poll[1] + dy[i];

                if (x < 0 || x >= N || y < 0 || y >= M) continue;

                if (graph[x][y] && dist[x][y] > dist[poll[0]][poll[1]] + 1) {
                    dist[x][y] = dist[poll[0]][poll[1]] + 1;
                    q.offer(new int[] {x, y});
                }
            }
        }
    }
}