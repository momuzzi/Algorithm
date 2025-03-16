import java.io.*;
import java.util.*;

public class Main {

    static int R;
    static int C;
    static char[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Character> alphaList;
    static boolean[] alphaVisit;
    static int max = 0;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        R = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);

        graph = new char[R + 1][C + 1];
        alphaList = new ArrayList<>();

        for (int i = 1; i <= R; i++) {
            String ss = br.readLine();
            for (int j = 1; j <= C; j++) {
                graph[i][j] = ss.charAt(j - 1);
                if (!alphaList.contains(graph[i][j])) {
                    alphaList.add(graph[i][j]);
                }
            }
        }

        alphaVisit = new boolean[alphaList.size()];
    }

    static void solve() {
        alphaVisit[alphaList.indexOf(graph[1][1])] = true;
        dfs(1, new int[] {1, 1});
        System.out.print(max);
    }

    static void dfs(int depth, int[] location) {
        max = Math.max(max, depth);
        for (int i = 0; i < 4; i++) {
            int moveX = location[0] + dx[i];
            int moveY = location[1] + dy[i];

            if (moveX < 1 || moveY < 1 || moveX > R || moveY > C) continue;

            int alphaIdx = alphaList.indexOf(graph[moveX][moveY]);

            if (!alphaVisit[alphaIdx]) {
                alphaVisit[alphaIdx] = true;
                dfs(depth + 1, new int[] {moveX, moveY});
                alphaVisit[alphaIdx] = false;
            }
        }
    }
}