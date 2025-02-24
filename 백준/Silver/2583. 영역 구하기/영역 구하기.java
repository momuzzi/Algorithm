import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int M;
    static int N;

    static int[][] graph;

    static Stack<int[]> s;

    static int width = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        graph = new int[N][M];

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int leftX = Integer.parseInt(st.nextToken());
            int leftY = Integer.parseInt(st.nextToken());
            int rightX = Integer.parseInt(st.nextToken());
            int rightY = Integer.parseInt(st.nextToken());

            for (int j = leftX; j < rightX; j++) {
                for (int k = leftY; k < rightY; k++) {
                    graph[j][k] = 1;
                }
            }
        }

        s = new Stack<>();

        List<Integer> result = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0) {
                    cnt++;
                    s.push(new int[] {i, j});
                    graph[i][j] = 1;
                    dfs();
                    result.add(width);
                    width = 0;
                }
            }
        }

        Collections.sort(result);

        System.out.println(cnt);

        for (int n : result) {
            System.out.print(n + " ");
        }
    }

    static void dfs() {
        if (s.isEmpty()) {
            return;
        }

        int[] pop = s.pop();
        width++;

        for (int i = 0; i < 4; i++) {
            int moveX = pop[0] + dx[i];
            int moveY = pop[1] + dy[i];

            if (moveX < 0 || moveX >= N || moveY < 0 || moveY >= M) continue;

            if (graph[moveX][moveY] == 1) continue;

            graph[moveX][moveY] = 1;

            s.push(new int[] {moveX, moveY});
            dfs();
        }
    }
}