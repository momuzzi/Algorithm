import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[][] graph;
    static int[][] dist;
    static int[] startLocation;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        graph = new int[n + 1][m + 1];
        dist = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());

                if (graph[i][j] == 2) {
                    startLocation = new int[] {i, j};
                    dist[i][j] = 0;
                }
            }
        }
    }

    static void solve() {
        LinkedList<int[]> q = new LinkedList<>();
        q.offerLast(startLocation);

        while (!q.isEmpty()) {
            int[] now = q.pollFirst();

            for (int i = 0; i < 4; i++) {
                int moveX = now[0] + dx[i];
                int moveY = now[1] + dy[i];

                if (moveX < 1 || moveY < 1 || moveX > n || moveY > m) continue;

                if (graph[moveX][moveY] == 1 && dist[moveX][moveY] == 0) {
                    dist[moveX][moveY] = dist[now[0]][now[1]] + 1;
                    q.offerLast(new int[] {moveX, moveY});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (graph[i][j] == 1 && dist[i][j] == 0) {
                    sb.append(-1 + " ");
                } else {
                    sb.append(dist[i][j] + " ");
                }
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}