import java.io.*;

public class Main {

    static boolean[][] graph = new boolean[10][10];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int point = 0;
        for (int i = 0; i < N; i++) {
            String[] txy = br.readLine().split(" ");

            int t = Integer.parseInt(txy[0]);
            int x = Integer.parseInt(txy[1]);
            int y = Integer.parseInt(txy[2]);

            if (t == 1) {
                goToGreen1(x, y);
                goToBlue1(x, y);
            } else if (t == 2) {
                goToGreen2(x, y);
                goToBlue2(x, y);
            } else {
                goToGreen3(x, y);
                goToBlue3(x, y);
            }

            point += checkGreen();
            point += checkBlue();

            underGreen();
            rightBlue();
        }

        int gCnt = 0;
        for (int i = 4; i < 10; i++) {
            for (int j = 0; j < 4; j++) {
                if (graph[i][j]) gCnt++;
            }
        }

        int bCnt = 0;
        for (int i = 4; i < 10; i++) {
            for (int j = 0; j < 4; j++) {
                if (graph[j][i]) bCnt++;
            }
        }

        System.out.println(point);
        System.out.print(gCnt + bCnt);
    }

    static void goToGreen1(int x, int y) {
        int gx = x;

        while (true) {

            if (gx + 1 > 9) break;

            if (graph[gx + 1][y]) break;

            gx++;
        }

        graph[gx][y] = true;
    }

    static void goToGreen2(int x, int y) {
        int gx = x;

        while (true) {
            int dx = gx + 1;

            if (dx > 9) break;

            if (graph[dx][y] || graph[dx][y + 1]) break;

            gx = dx;
        }

        graph[gx][y] = true;
        graph[gx][y + 1] = true;
    }

    static void goToGreen3(int x, int y) {
        int gx = x + 1;

        while (true) {
            int dx = gx + 1;

            if (dx > 9) break;

            if (graph[dx][y]) break;

            gx = dx;
        }

        graph[gx][y] = true;
        graph[gx - 1][y] = true;
    }

    static void goToBlue1(int x, int y) {
        int by = y;

        while (true) {
            int dy = by + 1;

            if (dy > 9) break;

            if (graph[x][dy]) break;

            by = dy;
        }

        graph[x][by] = true;
    }

    static void goToBlue2(int x, int y) {
        int by = y + 1;

        while (true) {
            int dy = by + 1;

            if (dy > 9) break;

            if (graph[x][dy]) break;

            by = dy;
        }

        graph[x][by] = true;
        graph[x][by - 1] = true;
    }

    static void goToBlue3(int x, int y) {
        int by = y;

        while (true) {
            int dy = by + 1;

            if (dy > 9) break;

            if (graph[x][dy] || graph[x + 1][dy]) break;

            by = dy;
        }

        graph[x][by] = true;
        graph[x + 1][by] = true;
    }

    static int checkGreen() {
        int point = 0;
        for (int i = 6; i < 10; i++) {
            boolean all = true;
            for (int j = 0; j < 4; j++) {
                if (!graph[i][j]) {
                    all = false;
                    break;
                }
            }

            if (all) {
                point++;

                for (int k = i; k >= 4; k--) {
                    for (int j = 0; j < 4; j++) {
                        graph[k][j] = graph[k - 1][j];
                    }
                }
            }
        }

        return point;
    }

    static int checkBlue() {
        int point = 0;
        for (int i = 6; i < 10; i++) {
            boolean all = true;
            for (int j = 0; j < 4; j++) {
                if (!graph[j][i]) {
                    all = false;
                    break;
                }
            }

            if (all) {
                point++;

                for (int k = i; k >= 4; k--) {
                    for (int j = 0; j < 4; j++) {
                        graph[j][k] = graph[j][k - 1];
                    }
                }
            }
        }

        return point;
    }

    static void underGreen() {
        int cnt = 0;

        for (int i = 4; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (graph[i][j]) {
                    cnt++;
                    break;
                }
            }
        }

        if (cnt == 0) return;

        for (int i = 9; i > 5; i--) {
            for (int j = 0; j < 4; j++) {
                graph[i][j] = graph[i - cnt][j];
                graph[i - cnt][j] = false;
            }
        }
    }

    static void rightBlue() {
        int cnt = 0;

        for (int i = 4; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (graph[j][i]) {
                    cnt++;
                    break;
                }
            }
        }

        if (cnt == 0) return;

        for (int i = 9; i > 5; i--) {
            for (int j = 0; j < 4; j++) {
                graph[j][i] = graph[j][i - cnt];
                graph[j][i - cnt] = false;
            }
        }
    }
}