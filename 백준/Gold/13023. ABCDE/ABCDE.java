import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static List<List<Integer>> list;
    static boolean[] visit;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.get(x).add(y);
            list.get(y).add(x);
        }
    }

    static void solve() {
        for (int i = 0; i < N; i++) {
            visit[i] = true;
            dfs(i, 0);
            visit[i] = false;

            if (answer == 1) {
                break;
            }
        }

        System.out.print(answer);
    }

    static void dfs(int idx, int depth) {
        if (depth == 4) {
            answer = 1;
            return;
        }

        for (int num : list.get(idx)) {
            if (!visit[num]) {
                visit[num] = true;
                dfs(num, depth + 1);
                visit[num] = false;
            }
        }
    }
}