import java.io.*;

public class Main {

    static int R, C, N;
    static int[][] graph;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] RCN = br.readLine().split(" ");
        R = Integer.parseInt(RCN[0]);
        C = Integer.parseInt(RCN[1]);
        N = Integer.parseInt(RCN[2]);

        graph = new int[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                graph[i][j] = s.charAt(j) == 'O' ? 0 : -1;
            }
        }

        for (int i = 2; i <= N; i++) {
            if (i % 2 == 0) {
                install(i);
            } else {
                bomb(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < R; j++) {
            for (int k = 0; k < C; k++) {
                sb.append(graph[j][k] == -1 ? '.' : 'O');
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void install(int t) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (graph[i][j] == -1) {
                    graph[i][j] = t;
                }
            }
        }
    }

    static void bomb(int t) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (graph[i][j] != -1 && graph[i][j] + 3 == t) {
                    graph[i][j] = -1;

                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];

                        if (x < 0 || x >= R || y < 0 || y >= C) continue;

                        if (k > 1 && graph[x][y] + 3 == t) continue;

                        graph[x][y] = -1;
                    }
                }
            }
        }
    }
}