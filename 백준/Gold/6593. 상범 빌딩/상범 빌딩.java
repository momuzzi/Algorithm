import java.io.*;
import java.util.*;

public class Main {

    static int L;
    static int R;
    static int C;
    static int[][][] graph;
    static boolean[][][] can;
    static int[] startLocation;
    static int[] endLocation;

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {-1, 1, 0 ,0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) break;

            graph = new int[L][R][C];
            can = new boolean[L][R][C];

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String s = br.readLine();
                    for (int k = 0; k < C; k++) {
                        can[i][j][k] = s.charAt(k) == '#' ? false : true;

                        if (s.charAt(k) == 'S') {
                            startLocation = new int[]{i, j, k};
                            graph[i][j][k] = 0;
                            continue;
                        }

                        if (s.charAt(k) == 'E') {
                            endLocation = new int[]{i, j, k};
                        }

                        graph[i][j][k] = -1;

                    }
                }

                br.readLine();
            }

            solve();
        }
    }

    static void solve() {
        bfs();
        int result = graph[endLocation[0]][endLocation[1]][endLocation[2]];
        System.out.println(result != -1 ? "Escaped in " + result + " minute(s)." : "Trapped!");
    }

    static void bfs() {
        LinkedList<int[]> q = new LinkedList<>();
        q.offerLast(startLocation);

        while (!q.isEmpty()) {
            int[] now = q.pollFirst();

            if (now[0] == endLocation[0] && now[1] == endLocation[1] && now[2] == endLocation[2]) {
                return;
            }

            for (int i = 0; i < 6; i++) {
                int moveX = now[1] + dx[i];
                int moveY = now[2] + dy[i];
                int moveZ = now[0] + dz[i];

                if (moveX < 0 || moveY < 0 || moveZ < 0 || moveX >= R || moveY >= C || moveZ >= L) continue;

                if (can[moveZ][moveX][moveY] && graph[moveZ][moveX][moveY] == -1) {
                    graph[moveZ][moveX][moveY] = graph[now[0]][now[1]][now[2]] + 1;
                    q.offerLast(new int[] {moveZ, moveX, moveY});
                }
            }
        }
    }
}