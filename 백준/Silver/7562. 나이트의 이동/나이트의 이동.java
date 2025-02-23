import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {-2, -2, -1, -1, 1, 2, 2, 1};
    static int[] dy = {1, -1, 2, -2, 2, 1, -1, -2};

    static int l;
    static LinkedList<int[]> q;
    static int[][] visit;

    static int nextX;
    static int nextY;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            l = Integer.parseInt(br.readLine());
            visit = new int[l][l];
            q = new LinkedList<>();

            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);

            q.add(new int[]{x, y});
            visit[x][y] = 0;

            String[] s2 = br.readLine().split(" ");
            nextX = Integer.parseInt(s2[0]);
            nextY = Integer.parseInt(s2[1]);

            bfs();

            sb.append(visit[nextX][nextY] + "\n");
        }

        System.out.print(sb);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int[] pop = q.pop();

            if (pop[0] == nextX && pop[1] == nextY) {
                return;
            }

            for (int i = 0; i < 8; i++) {
                int moveX = pop[0] + dx[i];
                int moveY = pop[1] + dy[i];

                if (moveX < 0 || moveX >= l || moveY < 0 || moveY >= l)
                    continue;

                if (visit[moveX][moveY] > 0)
                    continue;

                visit[moveX][moveY] = visit[pop[0]][pop[1]] + 1;
                q.add(new int[]{moveX, moveY});
            }
        }
    }
}