import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] graph;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N + 1][N + 1];
        visit = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solve() {
        dfs(1, 0);
        System.out.print(min);
    }

    // 1번과 2번 조합 or 2번과 1번 조합 동일하므로 idx로 오름차순 계산만
    static void dfs(int idx, int depth) {
        // 뎁스는 N/2까지
        if (depth == N / 2) {
            calculate();
            return;
        }

        for (int i = idx; i <= N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }

    static void calculate() {
        int visitTeam = 0;
        int nonVisitTeam = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (visit[i] && visit[j]) {
                    int ability = graph[i][j] + graph[j][i];
                    visitTeam += ability;
                }

                if (!visit[i] && !visit[j]) {
                    int ability = graph[i][j] + graph[j][i];
                    nonVisitTeam += ability;
                }
            }
        }

        min = Math.min(min, Math.abs(visitTeam - nonVisitTeam));
    }
}