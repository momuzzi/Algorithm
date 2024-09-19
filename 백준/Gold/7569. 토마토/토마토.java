import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int H;
    static int[][][] graph;
    static LinkedList<int[]> q;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        M = Integer.parseInt(tokenizer.nextToken()); // 가로 칸수
        N = Integer.parseInt(tokenizer.nextToken()); // 세로 칸수
        H = Integer.parseInt(tokenizer.nextToken()); // 판자 갯수

        q = new LinkedList<>();
        graph = new int[H][N][M];
        boolean existZero = false;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                StringTokenizer tokenizer1 = new StringTokenizer(reader.readLine(), " ");
                for (int k = 0; k < M; k++) {
                    int num = Integer.parseInt(tokenizer1.nextToken());
                    graph[i][j][k] = num;

                    // 익지 않은 토마토가 하나라도 있으면 여기 걸림.
                    if (num == 0) {
                        existZero = true;
                    }

                    // 익은 토마토들을 큐에 넣는다.
                    if (num == 1) {
                        q.add(new int[] {i, j, k});
                    }
                }
            }
        }

        // 이미 다 익어 있는 상태라면 0 출력
        if (!existZero) {
            System.out.print(0);
            return;
        }

        bfs();

        // 안익은 토마토가 있는지 체크
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (graph[i][j][k] == 0) {
                        System.out.print(-1);
                        return;
                    }
                }
            }
        }

        // 최댓값 - 1 출력
        int answer = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (graph[i][j][k] > answer) {
                        answer = graph[i][j][k];
                    }
                }
            }
        }

        System.out.print(answer - 1);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int h = poll[0];
            int x = poll[1];
            int y = poll[2];

            if (h + 1 < H) { // 위에칸 체크
                if (graph[h + 1][x][y] == 0) {
                    graph[h + 1][x][y] = graph[h][x][y] + 1;
                    q.add(new int[] {h + 1, x, y});
                }
            }
            
            if (h - 1 >= 0) { // 아래칸 체크
                if (graph[h - 1][x][y] == 0) {
                    graph[h - 1][x][y] = graph[h][x][y] + 1;
                    q.add(new int[] {h - 1, x, y});
                }
            }

            // 옆칸 체크
            for (int i = 0; i < 4; i++) {
                int moveDx = x + dx[i];
                int moveDy = y + dy[i];

                if (moveDx >= 0 && moveDy >= 0 && moveDx < N && moveDy < M) { // 이동한 범위 체크
                    if (graph[h][moveDx][moveDy] == 0) {
                        graph[h][moveDx][moveDy] = graph[h][x][y] + 1;
                        q.add(new int[] {h, moveDx, moveDy});
                    }
                }
            }
        }
    }
}