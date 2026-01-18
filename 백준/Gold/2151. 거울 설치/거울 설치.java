import java.io.*;
import java.util.*;

public class Main {

    static int N;

    // 북, 동, 남, 서
    static int[] rdx = {0, 1, 0, -1};
    static int[] rdy = {1, 0, -1, 0};
    static int[] ldx = {0, -1, 0, 1};
    static int[] ldy = {-1, 0, 1, 0};
    static int[] sdx = {-1, 0, 1, 0};
    static int[] sdy = {0, 1, 0, -1};

    static char[][] graph;
    static boolean[][][] visit;
    
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new char[N][N];
        visit = new boolean[N][N][4];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == '#') {
                    bfs(i, j);
                    System.out.print(ans);
                    return;
                }
            }
        }
    }

    static void bfs(int a, int b) {
        ArrayDeque<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < 4; i++) {
            q.offer(new int[] {a, b, i, 0});
            visit[a][b][i] = true;
        }

        while (!q.isEmpty()) {
            int[] poll = q.poll();

            if ((poll[0] != a || poll[1] != b) && graph[poll[0]][poll[1]] == '#') {
                ans = poll[3];
                return;
            }

            if (graph[poll[0]][poll[1]] == '!') {
                for (int i = 0; i < 2; i++) {
                    int x = poll[0];
                    int y = poll[1];
                    int d = poll[2];
                    if (i == 0) {
                        x += rdx[d];
                        y += rdy[d];
                        d++;

                        if (d == 4) d = 0;
                    } else {
                        x += ldx[d];
                        y += ldy[d];
                        d--;

                        if (d == -1) d = 3;
                    }

                    if (x < 0 || x >= N || y < 0 || y >= N) continue;

                    if (graph[x][y] == '*') continue;

                    if (x == a && y == b) continue;

                    if (!visit[x][y][d]) {
                        visit[x][y][d] = true;
                        q.offerLast(new int[] {x, y, d, poll[3] + 1});
                    }
                }
            }

            int x = poll[0] + sdx[poll[2]];
            int y = poll[1] + sdy[poll[2]];

            if (x < 0 || x >= N || y < 0 || y >= N) continue;

            if (graph[x][y] == '*') continue;

            if (x == a && y == b) continue;

            if (!visit[x][y][poll[2]]) {
                visit[x][y][poll[2]] = true;
                q.offerFirst(new int[] {x, y, poll[2], poll[3]});
            }
        }
    }
}