import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int K;
    static boolean[][] road;
    static boolean[][][] visit;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        K = Integer.parseInt(s[2]);

        road = new boolean[N][M];
        visit = new boolean[K + 1][N][M];

        for (int i = 0; i <= K; i++) {
            visit[i][0][0] = true;
        }

        for (int i = 0; i < N; i++) {
            String ss = br.readLine();
            for (int j = 0; j < M; j++) {
                road[i][j] = ss.charAt(j) == '0' ? true : false;
            }
        }
    }

    static void solve() {
        System.out.print(bfs());
    }

    static int bfs() {
        LinkedList<Node> q = new LinkedList<>();
        q.offerLast(new Node(0, 0, 1, 0));
        while (!q.isEmpty()) {
            Node node = q.pollFirst();

            if (node.x == N - 1 && node.y == M - 1) {
                return node.dist;
            }

            for (int i = 0; i < 4; i++) {
                int moveDx = node.x + dx[i];
                int moveDy = node.y + dy[i];

                if (moveDx < 0 || moveDy < 0 || moveDx >= N || moveDy >= M) continue;

                // 길인 경우
                if (road[moveDx][moveDy]) {
                    // 벽을 부순적이 있고, 벽을 부순 횟수 방문 배열에서 방문 안한 경우
                    if (node.brkCnt != 0 && !visit[node.brkCnt][moveDx][moveDy]) {
                        visit[node.brkCnt][moveDx][moveDy] = true;
                        q.offerLast(new Node(moveDx, moveDy, node.dist + 1, node.brkCnt));
                    }

                    // 벽을 부순적이 없고, 벽을 부수지 않은 방문 배열에서 방문 안한 경우
                    if (node.brkCnt == 0 && !visit[0][moveDx][moveDy]) {
                        visit[0][moveDx][moveDy] = true;
                        q.offerLast(new Node(moveDx, moveDy, node.dist + 1, node.brkCnt));
                    }

                    continue;
                }

                // 벽인 경우
                if (!road[moveDx][moveDy]) {
                    // 벽을 부순적이 K회 미만이고, 해당 부순 횟수 + 1 배열에서 방문하지 않은 경우
                    if (node.brkCnt < K && !visit[node.brkCnt + 1][moveDx][moveDy]) {
                        visit[node.brkCnt + 1][moveDx][moveDy] = true;
                        q.offerLast(new Node(moveDx, moveDy, node.dist + 1, node.brkCnt + 1));
                    }
                }
            }
        }

        return -1;
    }

    static class Node {
        int x;
        int y;
        int dist;
        int brkCnt;

        public Node(int x, int y, int dist, int brkCnt) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.brkCnt = brkCnt;
        }
    }
}