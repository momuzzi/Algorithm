import java.util.*;
import java.io.*;

public class Main {

    static int R;
    static int C;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0 ,0};
    static char[][] graph;
    static Deque<int[]> fq;
    static Deque<int[]> pq;
    static int[][] fVisit; // 불 방문 배열
    static int[][] pVisit; // 사람 방문 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        R = Integer.parseInt(str[0]);
        C = Integer.parseInt(str[1]);

        graph = new char[R][C];
        fVisit = new int[R][C];
        pVisit = new int[R][C];
        fq = new ArrayDeque<>();
        pq = new ArrayDeque<>();

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                graph[i][j] = input.charAt(j);
                fVisit[i][j] = -1;
                pVisit[i][j] = -1;

                if (graph[i][j] == 'F') {
                    fq.addLast(new int[] {i, j});
                    fVisit[i][j] = 0;
                    continue;
                }

                if (graph[i][j] == 'J') {
                    pq.addLast(new int[] {i, j});
                    pVisit[i][j] = 0;
                }
            }
        }

        // 불 bfs 처리
        fBfs();

        // 사람 bfs 처리
        int result = pBfs();
        if (result > 0) {
            System.out.print(result);
            return;
        }

        System.out.print("IMPOSSIBLE");
    }

    static void fBfs() {
        while (!fq.isEmpty()) {
            int[] arr = fq.pollFirst();

            int x = arr[0];
            int y = arr[1];

            for (int i = 0; i < 4; i++) {
                int moveX = x + dx[i];
                int moveY = y + dy[i];

                if (moveX < 0 || moveX > R - 1 || moveY < 0 || moveY > C - 1) {
                    continue;
                }

                if (graph[moveX][moveY] == '#' || graph[moveX][moveY] == 'F' || fVisit[moveX][moveY] != -1) {
                    continue;
                }

                fVisit[moveX][moveY] = fVisit[x][y] + 1;
                fq.addLast(new int[] {moveX, moveY});
            }
        }
    }

    static int pBfs() {
        while (!pq.isEmpty()) {
            int[] arr = pq.pollFirst();

            int x = arr[0];
            int y = arr[1];

            if (x == 0 || x == R - 1 || y == 0 || y == C - 1) {
                return pVisit[x][y] + 1;
            }

            for (int i = 0; i < 4; i++) {
                int moveX = x + dx[i];
                int moveY = y + dy[i];

                if (moveX < 0 || moveX > R - 1 || moveY < 0 || moveY > C - 1) {
                    continue;
                }

                if (graph[moveX][moveY] == '#' || graph[moveX][moveY] == 'F' || graph[moveX][moveY] == 'J' || pVisit[moveX][moveY] != -1) {
                    continue;
                }

                if (fVisit[moveX][moveY] == -1 || fVisit[moveX][moveY] > pVisit[x][y] + 1) {
                    pVisit[moveX][moveY] = pVisit[x][y] + 1;
                    pq.addLast(new int[] {moveX, moveY});
                }

            }
        }
        return 0;
    }
}