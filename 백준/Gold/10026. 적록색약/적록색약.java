import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

    static int N;
    static String[][] graph;
    static boolean[][] visited;
    static boolean[][] visited2;
    static LinkedList<int[]> q;
    static LinkedList<int[]> q2;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        N = Integer.parseInt(reader.readLine());

        graph = new String[N][N];
        visited = new boolean[N][N];
        visited2 = new boolean[N][N];
        q = new LinkedList<>();
        q2 = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String[] split = reader.readLine().split("");
            for (int j = 0; j < N; j++) {
                graph[i][j] = split[j];
            }
        }

        int common = 0;
        int redGreen = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    q.add(new int[] {i, j});
                    visited[i][j] = true;
                    bfs1();
                    common++;
                }
            }

            for (int k = 0; k < N; k++) {
                if (!visited2[i][k]) {
                    q2.add(new int[] {i, k});
                    visited2[i][k] = true;
                    bfs2();
                    redGreen++;
                }
            }
        }

        builder.append(common).append(" ").append(redGreen);

        System.out.print(builder);
    }

    // 정상
    static void bfs1() {
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];

            for (int i = 0; i < 4; i++) {
                int moveDx = x + dx[i];
                int moveDy = y + dy[i];

                if (moveDx >= 0 && moveDy >= 0 && moveDx < N && moveDy < N) {
                    if (!visited[moveDx][moveDy] && graph[x][y].equals(graph[moveDx][moveDy])) {
                        visited[moveDx][moveDy] = true;
                        q.add(new int[] {moveDx, moveDy});
                    }
                }
            }
        }
    }

    // 적녹색약
    static void bfs2() {
        while (!q2.isEmpty()) {
            int[] poll = q2.poll();
            int x = poll[0];
            int y = poll[1];

            for (int i = 0; i < 4; i++) {
                int moveDx = x + dx[i];
                int moveDy = y + dy[i];

                if (moveDx >= 0 && moveDy >= 0 && moveDx < N && moveDy < N) {
                    if (!visited2[moveDx][moveDy]) {
                        if (graph[x][y].equals("B")) {
                            if (graph[moveDx][moveDy].equals("B")) {
                                visited2[moveDx][moveDy] = true;
                                q2.add(new int[]{moveDx, moveDy});
                            }
                        } else {
                            if (graph[moveDx][moveDy].equals("R") || graph[moveDx][moveDy].equals("G")) {
                                visited2[moveDx][moveDy] = true;
                                q2.add(new int[]{moveDx, moveDy});
                            }
                        }
                    }
                }
            }
        }
    }
}