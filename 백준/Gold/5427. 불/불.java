import java.util.*;
import java.io.*;

public class Main {

    static char[][] graph;
    static Deque<int[]> fq;
    static Deque<int[]> pq;
    static int[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int r;
    static int c;
    static int startX;
    static int startY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            r = Integer.parseInt(s[0]);
            c = Integer.parseInt(s[1]);

            graph = new char[c][r];
            visit = new int[c][r];
            fq = new ArrayDeque<>();
            pq = new ArrayDeque<>();

            for (int j = 0; j < c; j++) {
                char[] arr = br.readLine().toCharArray();
                for (int k = 0; k < r; k++) {
                    graph[j][k] = arr[k];

                    if (arr[k] == '@') {
                        pq.addLast(new int[] {j, k});
                        startX = j;
                        startY = k;
                        continue;
                    }

                    if (arr[k] == '*') {
                        visit[j][k] = 0;
                        fq.addLast(new int[] {j, k});
                        continue;
                    }

                    visit[j][k] = -1;
                }
            }

            // 불 bfs 처리
            fBfs();

            // 사람 bfs 처리
            int result = pBfs();

            if (result > 0) {
                System.out.println(result);
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    static void fBfs() {

        while (!fq.isEmpty()) {
            int[] poll = fq.pollFirst();

            int x = poll[0];
            int y = poll[1];

            for (int i = 0; i < 4; i++) {
                int moveX = x + dx[i];
                int moveY = y + dy[i];

                if (moveX < 0 || moveX >= c || moveY < 0 || moveY >= r) continue;

                if (graph[moveX][moveY] == '#' || graph[moveX][moveY] == '*' || visit[moveX][moveY] != -1) continue;

                visit[moveX][moveY] = visit[x][y] + 1;
                fq.addLast(new int[] {moveX, moveY});
            }
        }
    }

    static int pBfs() {
        visit[startX][startY] = 0;

        while (!pq.isEmpty()) {
            int[] poll = pq.pollFirst();
            int x = poll[0];
            int y = poll[1];

            if (x == 0 || x == c - 1 || y == 0 || y == r - 1) {
                return visit[x][y] + 1;
            }

            for (int i = 0; i < 4; i++) {
                int moveX = x + dx[i];
                int moveY = y + dy[i];

                if (moveX < 0 || moveX >= c || moveY < 0 || moveY >= r) continue;

                if (graph[moveX][moveY] == '#' || graph[moveX][moveY] == '*' || graph[moveX][moveY] == '@') continue;

                if (visit[moveX][moveY] == -1 || visit[moveX][moveY] > visit[x][y] + 1) {
                    visit[moveX][moveY] = visit[x][y] + 1;
                    pq.addLast(new int[] {moveX, moveY});
                }
            }
        }

        return 0;
    }
}