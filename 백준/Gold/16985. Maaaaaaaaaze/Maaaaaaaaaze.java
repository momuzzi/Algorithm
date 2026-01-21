import java.io.*;
import java.util.*;

public class Main {

    static List<boolean[][]> list = new ArrayList<>();
    static int[] order = new int[5];
    static boolean[] visit = new boolean[5];
    static int[] rotate = new int[5];
    static boolean[][][] graph = new boolean[5][5][5];
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {-1, 1, 0 ,0, 0, 0};
    static int[] dy = {0, 0, -1, 1 ,0, 0};
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            boolean[][] graph = new boolean[5][5];

            for (int j = 0; j < 5; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 5; k++) {
                    graph[j][k] = st.nextToken().equals("1");
                }
            }

            list.add(graph);
        }

        bt(0);

        System.out.print(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    // 판 순서 순열 구하기
    static void bt(int depth) {
        if (ans == 12) return;

        if (depth == 5) {
            bt2(0);
            return;
        }

        for (int i = 0; i < 5; i++) {
            if (!visit[i]) {
                visit[i] = true;
                order[depth] = i;
                bt(depth + 1);
                visit[i] = false;
            }
        }
    }

    // 판 회전 순열 구하기
    static void bt2(int depth) {
        if (ans == 12) return;

        if (depth == 5) {
            createGraph();
            return;
        }

        for (int i = 0; i < 4; i++) {
            rotate[depth] = i;
            bt2(depth + 1);
        }
    }

    static void createGraph() {
        for (int i = 0; i < 5; i++) {
            int n = order[i];
            int cnt = rotate[i];

            boolean[][] rotateGraph = rotate(n, cnt);

            graph[i] = rotateGraph;
        }

        if (!graph[0][0][0] || !graph[4][4][4]) return; // 시작점이나 도착점이 방문 불가 하면 return

        int res = bfs();

        if (res == -1) return;

        ans = Math.min(ans, res);
    }

    static boolean[][] rotate(int n, int cnt) {
        boolean[][] rotateGraph = list.get(n);

        for (int i = 0; i < cnt; i++) {
            boolean[][] newGraph = new boolean[5][5];

            int x = 0;
            int y = 0;

            for (int j = 0; j < 5; j++) {
                for (int k = 4; k >= 0; k--) {
                    newGraph[x][y] = rotateGraph[k][j];
                    y++;
                }

                y = 0;
                x++;
            }

            rotateGraph = newGraph;
        }

        return rotateGraph;
    }

    static int bfs() {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0, 0, 0});
        boolean[][][] visit = new boolean[5][5][5];
        visit[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();

            int a = poll[0];
            int b = poll[1];
            int c = poll[2];

            if (a == 4 && b == 4 && c == 4) return poll[3];

            for (int i = 0; i < 6; i++) {
                int z = a + dz[i];
                int x = b + dx[i];
                int y = c + dy[i];

                if (z < 0 || z >= 5 || x < 0 || x >= 5 || y < 0 || y >= 5) continue;

                if (graph[z][x][y] && !visit[z][x][y]) {
                    visit[z][x][y] = true;
                    q.offer(new int[] {z, x, y, poll[3] + 1});
                }
            }
        }

        return -1;
    }
}