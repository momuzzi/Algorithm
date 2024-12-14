import java.io.*;
import java.util.*;

public class Main {

    static int[][] graph;
    static boolean[][] visit;
    static int n;
    static int m;
    static Deque<int[]> q;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        String[] input = rd.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        
        graph = new int[n + 1][m + 1];
        visit = new boolean[n + 1][m + 1];

        q = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(rd.readLine(), " ");
            for (int j = 1; j <= m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int picCnt = 0;
        int maxSize = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (graph[i][j] == 1 && visit[i][j] == false) {
                    visit[i][j] = true;
                    q.addLast(new int[] {i, j});
                    int size = bfs();
                    maxSize = Math.max(maxSize, size);
                    picCnt++;
                }
            }
        }

        System.out.print(picCnt + "\n" + maxSize);
    }

    static int bfs() {
        int size = 1;

        while (!q.isEmpty()) {
            int[] nm = q.pollFirst();
            int x = nm[0];
            int y = nm[1];

            for (int i = 0; i < 4; i++) {
                int moveX = x + dx[i];
                int moveY = y + dy[i];

                if (moveX < 1 || moveX > n || moveY < 1 || moveY > m) {
                    continue;
                }

                if (graph[moveX][moveY] == 1 && visit[moveX][moveY] == false) {
                    visit[moveX][moveY] = true;
                    q.addLast(new int[] {moveX, moveY});
                    size++;
                }
            }
        }

        return size;
    }
}