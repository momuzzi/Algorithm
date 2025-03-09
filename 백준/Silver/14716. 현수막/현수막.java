import java.io.*;
import java.util.*;

public class Main {

    static int M, N;
    static boolean[][] graph;
    static boolean[][] visit;
    static int[] dx = {-1, 1 ,0 ,0, -1, -1, 1, 1};
    static int[] dy = {0 ,0, -1, 1, -1, 1, 1, -1};

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        M = Integer.parseInt(s[0]);
        N = Integer.parseInt(s[1]);

        graph = new boolean[M][N];
        visit = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
            }
        }
    }

    static void solve() {
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0 ; j < N; j++) {
                if (graph[i][j] && !visit[i][j]) {
                    visit[i][j] = true;
                    bfs(new int[] {i, j});
                    cnt++;
                }
            }
        }

        System.out.print(cnt);
    }

    static void bfs(int[] arr) {
        LinkedList<int[]> q = new LinkedList<>();
        q.offerLast(arr);

        while (!q.isEmpty()) {
            int[] now = q.pollFirst();

            for (int i = 0; i < dx.length; i++) {
                int moveX = now[0] + dx[i];
                int moveY = now[1] + dy[i];

                if (moveX < 0 || moveY < 0 || moveX >= M || moveY >= N) continue;

                if (graph[moveX][moveY] && !visit[moveX][moveY]) {
                    visit[moveX][moveY] = true;
                    q.offerLast(new int[] {moveX, moveY});
                }
            }
        }
    }
}