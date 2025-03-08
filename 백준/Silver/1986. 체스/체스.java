import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static boolean[][] graph;

    static int queenCnt;
    static int knightCnt;
    static int pawnCnt;

    static int[][] queenLocation;
    static int[][] knightLocation;
    static int[][] pawnLocation;


    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        graph = new boolean[N + 1][M + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        queenCnt = Integer.parseInt(st.nextToken());

        if (queenCnt != 0) {
            queenLocation = new int[queenCnt][2];
            for (int i = 0; i < queenCnt; i++) {
                queenLocation[i][0] = Integer.parseInt(st.nextToken());
                queenLocation[i][1] = Integer.parseInt(st.nextToken());

                graph[queenLocation[i][0]][queenLocation[i][1]] = true;
            }
        }

        st = new StringTokenizer(br.readLine());
        knightCnt = Integer.parseInt(st.nextToken());

        if (knightCnt != 0) {
            knightLocation = new int[knightCnt][2];
            for (int i = 0; i < knightCnt; i++) {
                knightLocation[i][0] = Integer.parseInt(st.nextToken());
                knightLocation[i][1] = Integer.parseInt(st.nextToken());

                graph[knightLocation[i][0]][knightLocation[i][1]] = true;
            }
        }

        st = new StringTokenizer(br.readLine());
        pawnCnt = Integer.parseInt(st.nextToken());

        if (pawnCnt != 0) {
            pawnLocation = new int[pawnCnt][2];
            for (int i = 0; i < pawnCnt; i++) {
                pawnLocation[i][0] = Integer.parseInt(st.nextToken());
                pawnLocation[i][1] = Integer.parseInt(st.nextToken());

                graph[pawnLocation[i][0]][pawnLocation[i][1]] = true;
            }
        }
    }

    static void solve() {
        for (int i = 0; i < queenCnt; i++) {
            queen(queenLocation[i][0], queenLocation[i][1]);
        }

        for (int i = 0; i < knightCnt; i++) {
            knight(knightLocation[i][0], knightLocation[i][1]);
        }

        int safe = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (!graph[i][j]) {
                    safe++;
                }
            }
        }

        System.out.print(safe);
    }

    static void queen(int x, int y) {
        // 좌 처리
        int copyY = y;
        while (copyY > 0) {
            if ((pawnCnt != 0 && checkPawn(x, copyY)) || (knightCnt != 0 && checkKnight(x, copyY))) break;

            graph[x][copyY] = true;
            copyY--;
        }

        // 우 처리
        copyY = y + 1;
        while (copyY <= M) {
            if ((pawnCnt != 0 && checkPawn(x, copyY)) || (knightCnt != 0 && checkKnight(x, copyY))) break;

            graph[x][copyY] = true;
            copyY++;
        }

        // 상 처리
        int copyX = x;
        while (copyX > 0) {
            if ((pawnCnt != 0 && checkPawn(copyX, y)) || (knightCnt != 0 && checkKnight(copyX, y))) break;

            graph[copyX][y] = true;
            copyX--;
        }

        // 하 처리
        copyX = x + 1;
        while (copyX <= N) {
            if ((pawnCnt != 0 && checkPawn(copyX, y)) || (knightCnt != 0 && checkKnight(copyX, y))) break;

            graph[copyX][y] = true;
            copyX++;
        }

        // 좌 하 대각 처리
        copyX = x + 1;
        copyY = y - 1;
        while (copyX <= N && copyY > 0) {
            if ((pawnCnt != 0 && checkPawn(copyX, copyY)) || (knightCnt != 0 && checkKnight(copyX, copyY))) break;

            graph[copyX][copyY] = true;
            copyX++;
            copyY--;
        }

        // 좌 상 대각 처리
        copyX = x - 1;
        copyY = y - 1;
        while (copyX > 0 && copyY > 0) {
            if ((pawnCnt != 0 && checkPawn(copyX, copyY)) || (knightCnt != 0 && checkKnight(copyX, copyY))) break;

            graph[copyX][copyY] = true;
            copyX--;
            copyY--;
        }

        // 우 상 대각 처리
        copyX = x - 1;
        copyY = y + 1;
        while (copyX > 0 && copyY <= M) {
            if ((pawnCnt != 0 && checkPawn(copyX, copyY)) || (knightCnt != 0 && checkKnight(copyX, copyY))) break;

            graph[copyX][copyY] = true;
            copyX--;
            copyY++;
        }

        // 우 하 대각 처리
        copyX = x + 1;
        copyY = y + 1;
        while (copyX <= N && copyY <= M) {
            if ((pawnCnt != 0 && checkPawn(copyX, copyY)) || (knightCnt != 0 && checkKnight(copyX, copyY))) break;

            graph[copyX][copyY] = true;
            copyX++;
            copyY++;
        }
    }

    static boolean checkPawn(int x, int y) {
        for (int i = 0; i < pawnCnt; i++) {
            int pawnX = pawnLocation[i][0];
            int pawnY = pawnLocation[i][1];

            if (x == pawnX && y == pawnY) return true;
        }

        return false;
    }

    static boolean checkKnight(int x, int y) {
        for (int i = 0; i < knightCnt; i++) {
            int knightX = knightLocation[i][0];
            int knightY = knightLocation[i][1];

            if (x == knightX && y == knightY) return true;
        }

        return false;
    }

    static void knight(int x, int y) {
        int[] dx = new int[] {-1, -2, -2, -1, 1, 2, 2, 1};
        int[] dy = new int[] {-2, -1, 1, 2, 2, 1, -1, -2};

        for (int i = 0; i < 8; i++) {
            int moveX = x + dx[i];
            int moveY = y + dy[i];

            if (moveX < 1 || moveY < 1 || moveX > N || moveY > M) continue;
            if (graph[moveX][moveY]) continue;

            graph[moveX][moveY] = true;
        }
    }
}