import java.io.*;
import java.util.*;

public class Main {

    static char[][] graph;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        graph = new char[12][6];

        for (int i = 0; i < 12; i++) {
            String s = br.readLine();
            for (int j = 0; j < 6; j++) {
                graph[i][j] = s.charAt(j);
            }
        }

        int cnt = 0;
        while (true) {
            visit = new boolean[12][6];
            boolean pop = false;

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (!visit[i][j] && graph[i][j] != '.') {
                        if (bfs(i, j)) {
                            delete(i, j);
                            pop = true;
                        }
                    }
                }
            }

            down();

            if (!pop) break;
            cnt++;
        }

        System.out.print(cnt);
    }

    static boolean bfs(int a, int b) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {a, b});
        visit[a][b] = true;
        int cnt = 1;

        while (!q.isEmpty()) {
            int[] poll = q.poll();

            for (int i = 0; i < 4; i++) {
                int x = poll[0] + dx[i];
                int y = poll[1] + dy[i];

                if (x < 0 || x >= 12 || y < 0 || y >= 6) continue;

                if (graph[x][y] == graph[a][b] && !visit[x][y]) {
                    visit[x][y] = true;
                    q.offer(new int[] {x, y});
                    cnt++;
                }
            }
        }

        return cnt >= 4;
    }

    static void delete(int a, int b) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {a, b});
        char c = graph[a][b];
        graph[a][b] = '.';

        while (!q.isEmpty()) {
            int[] poll = q.poll();

            for (int i = 0; i < 4; i++) {
                int x = poll[0] + dx[i];
                int y = poll[1] + dy[i];

                if (x < 0 || x >= 12 || y < 0 || y >= 6) continue;

                if (graph[x][y] == c) {
                    graph[x][y] = '.';
                    q.offer(new int[] {x, y});
                }
            }
        }
    }

    static void down() {
        ArrayDeque<Character> q = new ArrayDeque<>();
        for (int i = 0; i < 6; i++) {
            for (int j = 11; j >= 0; j--) {
                if (graph[j][i] != '.') {
                    q.offer(graph[j][i]);
                }
            }

            int j = 11;
            while (!q.isEmpty()) {
                graph[j][i] = q.poll();
                j--;
            }

            while (j >= 0) {
                graph[j][i] = '.';
                j--;
            }
        }
    }
}