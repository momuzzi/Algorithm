import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] start;
    static int[] end;
    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};
    static int[][] graph;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        start = new int[2];
        end = new int[2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        start[0] = Integer.parseInt(st.nextToken());
        start[1] = Integer.parseInt(st.nextToken());
        end[0] = Integer.parseInt(st.nextToken());
        end[1] = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
    }

    static void solve() {
        LinkedList<int[]> q = new LinkedList<>();
        q.offerLast(new int[] {start[0], start[1]});

        while (!q.isEmpty()) {
            int[] now = q.pollFirst();

            if (now[0] == end[0] && now[1] == end[1]) {
                System.out.print(graph[end[0]][end[1]]);
                return;
            }

            for (int i = 0; i < dx.length; i++) {
                int moveX = now[0] + dx[i];
                int moveY = now[1] + dy[i];

                if (moveX < 0 || moveY < 0 || moveX >= N || moveY >= N) continue;
                if (moveX == start[0] && moveY == start[1]) continue;
                if (graph[moveX][moveY] == 0) {
                    graph[moveX][moveY] = graph[now[0]][now[1]] + 1;
                    q.offerLast(new int[] {moveX, moveY});
                }
            }
        }

        System.out.print(-1);
    }
}