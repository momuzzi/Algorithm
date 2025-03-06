import java.io.*;
import java.util.*;

public class Main {

    static int M;
    static int N;

    static boolean[][] graph;

    static int[] dx = {-1, 1, 0 ,0};
    static int[] dy = {0, 0, -1 ,1};


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

        for (int i = 0; i < M; i++) {
            String ss = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = ss.charAt(j) == '0' ? true : false;
            }
        }
    }

    static void solve() {
        for (int i = 0; i < N; i++) {
            if (graph[0][i]) {
                graph[0][i] = false;
                if (dfs(new int[]{0, i})) {
                    System.out.print("YES");
                    return;
                }
            }
        }

        System.out.print("NO");
    }

    static boolean dfs(int[] arr) {
        LinkedList<int[]> stack = new LinkedList<>();
        stack.offerLast(arr);

        while(!stack.isEmpty()) {
            int[] now = stack.pollLast();

            for (int i = 0; i < 4; i++) {
                int moveX = now[0] + dx[i];
                int moveY = now[1] + dy[i];

                if (moveX < 0 || moveY < 0 || moveX >= M || moveY >= N) continue;

                if (graph[moveX][moveY]) {
                    if (moveX == M - 1) {
                        return true;
                    }
                    
                    graph[moveX][moveY] = false;
                    stack.offerLast(new int[] {moveX, moveY});
                }
            }
        }

        return false;
    }
}