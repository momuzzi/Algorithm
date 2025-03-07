import java.io.*;
import java.util.*;

public class Main {

    static int R;
    static int C;
    static char[][] graph;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0 ,0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        R = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);

        graph = new char[R][C];
        visit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String ss = br.readLine();
            for (int j = 0; j < C; j++) {
                graph[i][j] = ss.charAt(j);
            }
        }
    }

    static void solve() {
        int sheep = 0;
        int wolf = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (graph[i][j] != '#' && !visit[i][j]) {
                    int[] result = bfs(new int[]{i, j});
                    
                    if (result[0] > result[1]) {
                        sheep += result[0];
                    } else {
                        wolf += result[1];
                    }
                }
            }
        }

        System.out.print(sheep + " " + wolf);
    }

    static int[] bfs(int[] arr) {
        LinkedList<int[]> q = new LinkedList<>();
        q.offerLast(arr);
        visit[arr[0]][arr[1]] = true;

        int sheep = 0;
        int wolf = 0;
        while (!q.isEmpty()) {
            int[] now = q.pollFirst();

            if (graph[now[0]][now[1]] == 'o') {
                sheep++;
            }

            if (graph[now[0]][now[1]] == 'v') {
                wolf++;
            }

            for (int i = 0; i < 4; i++) {
                int moveX = now[0] + dx[i];
                int moveY = now[1] + dy[i];

                if (moveX < 0 || moveY < 0 || moveX >= R || moveY >= C) continue;

                if (graph[moveX][moveY] == '#' || visit[moveX][moveY]) continue;

                visit[moveX][moveY] = true;
                q.offerLast(new int[] {moveX, moveY});
            }
        }

        return new int[] {sheep, wolf};
    }
}