import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] g;
    static boolean[] v;
    static Stack<Integer> s;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        g = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                g[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
    static void solve() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s = new Stack<>();
                v = new boolean[N];
                s.push(i);
                dfs(j);
                sb.append(v[j] ? 1 : 0).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int to) {
        while (!s.isEmpty()) {
            int now = s.pop();

            for (int i = 0; i < N; i++) {
                if (g[now][i] == 1 && !v[i]) {
                    s.push(i);
                    v[i] = true;
                    if (i == to) return;
                }
            }
        }
    }
}