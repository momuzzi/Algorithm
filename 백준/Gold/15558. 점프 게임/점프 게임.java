import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int k;
    static boolean[][] line; //[x][0] 왼쪽 , [x][1] 오른쪽
    static boolean[][] visit;
    static int[] dx = {1, -1};

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        line = new boolean[N][2];
        visit = new boolean[N][2];

        String s = br.readLine();
        for (int i = 0; i < N; i++) {
            line[i][0] = s.charAt(i) == '1' ? true : false;
        }

        String ss = br.readLine();
        for (int i = 0; i < N; i++) {
            line[i][1] = ss.charAt(i) == '1' ? true : false;
        }
    }

    static void solve() {
        boolean result = bfs();
        System.out.println(result ? 1 : 0);
    }

    static boolean bfs() {
        LinkedList<int[]> q = new LinkedList<>();
        q.offerLast(new int[] {0, 0, 0});

        while (!q.isEmpty()) {
            int[] now = q.pollFirst();

            for (int i = 0; i < 3; i++) {
                int moveX;
                int moveY;

                if (i == 2) {
                    moveX = now[0] + k;
                    moveY = now[1] == 1 ? 0 : 1;
                } else {
                    moveX = now[0] + dx[i];
                    moveY = now[1];
                }

                if (moveX > N - 1) {
                    return true;
                }

                if (moveX < 0 || moveX <= now[2]) continue;

                if (line[moveX][moveY] && !visit[moveX][moveY]) {
                    visit[moveX][moveY] = true;
                    q.offerLast(new int[] {moveX, moveY, now[2] + 1});
                }
            }
        }

        return false;
    }
}