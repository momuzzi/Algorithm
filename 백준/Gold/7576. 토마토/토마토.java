import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static int M;
    static int N;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0 ,0};
    static int[][] graph;
    static LinkedList<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str = reader.readLine();
        String[] strArray = str.split(" ");
        M = Integer.parseInt(strArray[0]);
        N = Integer.parseInt(strArray[1]);
        q = new LinkedList<>();
        graph = new int[N][M]; // 토마토 상자

        // 토마토 상자 채우기
        // 1 : 익은 토마토
        // 0 : 안 익은 토마토
        // -1 : 토마토가 없는 칸

        boolean zero = false;
        int index = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(tokenizer.nextToken());
                if (graph[i][j] == 1) {
                    q.add(new int[] {i, j});
                    index++;
                }
                if (graph[i][j] == 0) {
                    zero = true;
                }
            }
        }

        // 저장될 때부터 모든 토마토가 익어있는 상태라면 0 출력
        if (!zero) {
            System.out.print(0);
            return;
        }

        bfs();

        // 결과에서 익지 않은 토마토가 존재하면 -1 출력
        for (int[] num : graph) {
            boolean existZero = false;
            for (int i = 0; i < M; i++) {
                if (num[i] == 0) {
                    existZero = true;
                    break;
                }
            }
            if (existZero) {
                System.out.print(-1);
                return;
            }
        }

        // 최댓값 출력
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] > answer) {
                    answer = graph[i][j];
                }
            }
        }

        // 날짜 카운팅을 0부터 안하고 1부터 시작해서 -1
        System.out.print(answer - 1);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            for (int i = 0; i < 4; i++) {
                int moveDx = poll[0] + dx[i];
                int moveDy = poll[1] + dy[i];

                if (moveDx >= 0 && moveDy >= 0 && moveDx < N && moveDy < M) {
                    if (graph[moveDx][moveDy] == 0) {
                        graph[moveDx][moveDy] = graph[poll[0]][poll[1]] + 1;
                        q.add(new int[] {moveDx, moveDy});
                    }
                }
            }
        }
    }
}