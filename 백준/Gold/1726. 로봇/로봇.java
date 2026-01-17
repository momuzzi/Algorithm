import java.io.*;
import java.util.*;

public class Main {

    static int M, N;
    static boolean[][] graph;
    static boolean[][][] visit;
    static int gx, gy, gd;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] dd = {4, 1, 3, 2};
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] MN = br.readLine().split(" ");
        M = Integer.parseInt(MN[0]);
        N = Integer.parseInt(MN[1]);

        graph = new boolean[M + 1][N + 1];
        visit = new boolean[M + 1][N + 1][4];

        StringTokenizer st;
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                graph[i][j] = st.nextToken().equals("0") ? true : false;
            }
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        gx = Integer.parseInt(st.nextToken());
        gy = Integer.parseInt(st.nextToken());
        gd = Integer.parseInt(st.nextToken());

        bfs(x, y, getDIdx(d));

        System.out.print(ans);
    }

    static void bfs(int x, int y, int dIdx) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {x, y, dIdx, 0});
        visit[x][y][dIdx] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();

            if (poll[0] == gx && poll[1] == gy && poll[2] == getDIdx(gd)) {
                ans = poll[3];
                return;
            }

            for (int i = 0; i < 3; i++) {
                int moveDIdx = poll[2];

                if (i == 0) {
                    for (int j = 1; j <= 3; j++) {
                        if (!canGo(poll[0], poll[1], poll[2], j)) break;

                        int moveX = poll[0] + j * dx[poll[2]];
                        int moveY = poll[1] + j * dy[poll[2]];

                        if (graph[moveX][moveY] && !visit[moveX][moveY][moveDIdx]) {
                            visit[moveX][moveY][moveDIdx] = true;
                            q.offer(new int[] {moveX, moveY, moveDIdx, poll[3] + 1});
                        }
                    }

                    continue;
                } else if (i == 1) {
                    moveDIdx = right(poll[2]);
                } else {
                    moveDIdx = left(poll[2]);
                }

                if (!visit[poll[0]][poll[1]][moveDIdx]) {
                    visit[poll[0]][poll[1]][moveDIdx] = true;
                    q.offer(new int[] {poll[0], poll[1], moveDIdx, poll[3] + 1});
                }
            }
        }
    }

    static int getDIdx(int d) {
        for (int i = 0; i < 4; i++) {
            if (d == dd[i]) {
                return i;
            }
        }

        return -1;
    }

    static int right(int idx) {
        idx += 1;

        return idx == 4 ? 0 : idx;
    }

    static int left(int idx) {
        idx -= 1;

        return idx == -1 ? 3 : idx;
    }

    static boolean canGo(int x, int y, int d, int m) {
        int nx = x;
        int ny = y;
        for (int i = 0; i < m; i++) {
            nx += dx[d];
            ny += dy[d];

            if (nx < 1 || nx > M || ny < 1 || ny > N) return false;

            if (!graph[nx][ny]) return false;
        }

        return true;
    }
}