import java.io.*;
import java.util.*;

public class Main {

    static int w;
    static int h;
    static int[][] graph;
    static boolean[][] visited;
    static LinkedList<int[]> q;

    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        while(true) {
            String[] s = reader.readLine().split(" ");
            w = Integer.parseInt(s[0]);
            h = Integer.parseInt(s[1]);

            if (w == 0 && h == 0) {
                break;
            }

            graph = new int[h + 1][w + 1];
            visited = new boolean[h + 1][w + 1];

            for (int i = 1; i <= h; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine() , " ");
                for (int j = 1; j <= w; j++) {
                    graph[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }
            int cnt = 0;
            for (int i = 1; i <= h; i++) {
                for (int j = 1; j <= w; j++) {
                    if (graph[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }

            builder.append(cnt).append("\n");
        }

        System.out.print(builder);
    }

    static void bfs(int x, int y) {
        q = new LinkedList<>();
        q.add(new int[] {x, y});
        visited[x][y] = true;
        while (!q.isEmpty()) {
            int[] poll = q.poll();

            for (int i = 0; i < 8; i++) {
                int moveDx = poll[0] + dx[i];
                int moveDy = poll[1] + dy[i];

                if (moveDx > 0 && moveDy > 0 && moveDx <= h && moveDy <= w) {
                    if (graph[moveDx][moveDy] == 1 && !visited[moveDx][moveDy]) {
                        q.add(new int[] {moveDx, moveDy});
                        visited[moveDx][moveDy] = true;
                    }
                }
            }
        }
    }
}