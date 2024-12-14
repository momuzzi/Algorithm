import java.io.*;
import java.util.*;

public class Main {

    static int[][] graph;
    static int[][] dist;
    static int N;
    static int M;
    static Deque<int[]> q;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        String[] input = rd.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        graph = new int[N + 1][M + 1];
        dist = new int[N + 1][M + 1];
        dist[1][1] = 1;

        q = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            String str = rd.readLine();
            for (int j = 1; j <= M; j++) {
                graph[i][j] = Character.getNumericValue(str.charAt(j - 1));
            }
        }

        q.addLast(new int[] {1, 1});
        bfs();

        System.out.print(dist[N][M]);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int[] nm = q.pollFirst();
            int x = nm[0];
            int y = nm[1];

            for (int i = 0; i < 4; i++) {
                int moveX = x + dx[i];
                int moveY = y + dy[i];

                if (moveX < 1 || moveX > N || moveY < 1 || moveY > M) {
                    continue;
                }

                if (graph[moveX][moveY] == 1 && dist[moveX][moveY] == 0) {
                    dist[moveX][moveY] = dist[x][y] + 1;
                    q.addLast(new int[] {moveX, moveY});
                }
            }
        }
    }
}