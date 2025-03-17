import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int C;
    static int[][] graph = new int[11][11];;
    static boolean[] visit = new boolean[11]; // i번째 포지션에 선정된 선수 번호 저장
    static int max = 0;

    public static void main(String[] args) throws Exception {
        C = Integer.parseInt(br.readLine());
        for (int i = 0; i < C; i++) {
            max = 0;
            init();
            solve();
        }
    }

    static void init() throws Exception {
        for (int i = 0 ; i < 11; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 11; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solve() {
        dfs(0, 0);
        System.out.println(max);
    }

    static void dfs(int depth, int sum) {
        if (depth == 11) {
            max = Math.max(max, sum);
            return;
        }

        for (int j = 0; j < 11; j++) {
            if (graph[depth][j] != 0 && !visit[j]) {
                visit[j] = true;
                dfs(depth + 1, sum + graph[depth][j]);
                visit[j] = false;
            }
        }
    }
}