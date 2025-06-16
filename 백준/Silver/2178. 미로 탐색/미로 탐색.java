import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[][] graph;
    static LinkedList<int[]> q;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        init();
        solve();
        System.out.print(graph[N - 1][M - 1]);
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] inputArr = input.split(" ");
        N = Integer.parseInt(inputArr[0]);
        M = Integer.parseInt(inputArr[1]);

        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0 ; j < M; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

        q = new LinkedList<>();
        q.offerLast(new int[] {0, 0});
    }

    static void solve() {
        while (!q.isEmpty()) {
            int[] poll = q.pollFirst();
            int nowX = poll[0];
            int nowY = poll[1];

            for (int i = 0; i < 4; i++) {
                int moveX = nowX + dx[i];
                int moveY = nowY + dy[i];

                if (moveX >= 0 && moveX < N && moveY >= 0 && moveY < M && graph[moveX][moveY] == 1) {
                    graph[moveX][moveY] = graph[nowX][nowY] + 1;
                    q.offerLast(new int[] {moveX, moveY});
                }
            }
        }
    }
}