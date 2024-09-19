import java.io.*;
import java.util.*;

public class Main {

    static int dx[] = {0,0,-1,1};
    static int dy[] = {-1,1,0,0};
    static int N;
    static int M;
    static int[][] graph;
    static LinkedList<int[]> q;
    static StringTokenizer tokenizer;
    static int maxSafe = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        tokenizer = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        bt(0);

        System.out.print(maxSafe);
    }

    static void bt(int wall) {
        //벽이 3개가 설치 된 경우 bfs 탐색 시작
        if (wall == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(graph[i][j] == 0) {
                    graph[i][j] = 1;
                    bt(wall + 1);
                    graph[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        int[][] thisGraph = new int[N][M];

        for (int i = 0; i < N; i++) {
            thisGraph[i] = graph[i].clone();
        }

        q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (thisGraph[i][j] == 2) {
                    q.add(new int[] {i ,j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];

            for (int i = 0; i < 4; i++) {
                int moveDx = x + dx[i];
                int moveDy = y + dy[i];

                if (moveDx >= 0 && moveDy >= 0 && moveDx < N && moveDy < M) {
                    if (thisGraph[moveDx][moveDy] == 0) {
                        thisGraph[moveDx][moveDy] = 2;
                        q.add(new int[] {moveDx, moveDy});
                    }
                }
            }
        }

        int safe = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (thisGraph[i][j] == 0) {
                    safe++;
                }
            }
        }

        if (safe > maxSafe) {
            maxSafe = safe;
        }
    }
}