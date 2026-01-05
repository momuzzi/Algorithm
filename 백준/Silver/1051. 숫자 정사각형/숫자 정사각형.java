import java.io.*;

public class Main {

    static int N, M;
    static int[][] graph;
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = s.charAt(j) - '0';
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int min = Math.min(N - i, M - j) - 1;

                if (ans >= min + 1) continue;

                while (min >= 0) {
                    if (check(i, j, graph[i][j], min)) {
                        ans = Math.max(ans, min + 1);
                        break;
                    }

                    min--;
                }
            }
        }

        System.out.print(ans * ans);
    }

    static boolean check(int a, int b, int num, int size) {
        for (int i = 0; i < 3; i++) {
            int x = a + size * dx[i];
            int y = b + size * dy[i];

            if (x >= N || y >= M) return false;

            if (graph[x][y] != num) return false;
        }

        return true;
    }
}