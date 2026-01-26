import java.io.*;

public class Main {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int a = Integer.parseInt(br.readLine());

        int[][] graph = new int[N][N];

        int NN = N * N;

        int ansX = 1;
        int ansY = 1;

        int x = 0;
        int y = 0;
        graph[x][y] = NN;
        NN--;
        while (NN > 0) {
            for (int i = 0; i < 4; i++) {
                while (true) {
                    x = x + dx[i];
                    y = y + dy[i];

                    if (x < 0 || x >= N || y < 0 || y >= N) {
                        x = x - dx[i];
                        y = y - dy[i];
                        break;
                    }

                    if (graph[x][y] != 0) {
                        x = x - dx[i];
                        y = y - dy[i];
                        break;
                    }

                    if (NN == a) {
                        ansX = x + 1;
                        ansY = y + 1;
                    }

                    graph[x][y] = NN;
                    NN--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(graph[i][j] + " ");
            }
            sb.append("\n");
        }

        sb.append(ansX + " " + ansY);

        System.out.print(sb);
    }
}