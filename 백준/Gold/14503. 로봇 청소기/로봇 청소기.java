import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[][] room;
    static int r;
    static int c;
    static int d;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1 ,1};
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);

        room = new int[N][M];

        String[] rcd = br.readLine().split(" ");
        r = Integer.parseInt(rcd[0]);
        c = Integer.parseInt(rcd[1]);
        d = Integer.parseInt(rcd[2]);

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solve() {
        while (true) {
            if (room[r][c] == 0) {
                room[r][c] = 2;
                cnt++;
            }
            
            if (!hasDirtyRoom()) {
                if (canBack()) { // 후진 가능하다면 후진한 이후 46번 라인으로 돌아간다
                    continue;
                } else {
                    break; // 후진이 불가능 하다면 청소기 동작을 멈춘다
                }
            } else { // 현재 칸에서 네 방향에서 청소되지 않은 빈칸이 존재하는 경우
                turnLeft();
                tryFront();
            }
        }

        System.out.print(cnt);
    }

    static boolean hasDirtyRoom() {
        for (int i = 0; i < 4; i++) {
            int moveX = r + dx[i];
            int moveY = c + dy[i];

            if (moveX >= 0 && moveX < N && moveY >= 0 && moveY < M) {
                if (room[moveX][moveY] == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    static boolean canBack() {
        if (d == 0) {
            if (r + 1 < N) {
                if (room[r + 1][c] != 1) {
                    r++;
                    return true;
                }
            }
        }

        if (d == 1) {
            if (c - 1 >= 0) {
                if (room[r][c - 1] != 1) {
                    c--;
                    return true;
                }
            }
        }

        if (d == 2) {
            if (r - 1 >= 0) {
                if (room[r - 1][c] != 1) {
                    r--;
                    return true;
                }
            }
        }

        if (d == 3) {
            if (c + 1 < M) {
                if (room[r][c + 1] != 1) {
                    c++;
                    return true;
                }
            }
        }

        return false;
    }

    static void turnLeft() {
        if (d == 0) {
            d = 3;
            return;
        }

        d--;
    }

    static void tryFront() {
        if (d == 0) {
            if (r - 1 >= 0) {
                if (room[r - 1][c] == 0) {
                    r--;
                }
            }
        }

        if (d == 1) {
            if (c + 1 < M) {
                if (room[r][c + 1] == 0) {
                    c++;
                }
            }
        }

        if (d == 2) {
            if (r + 1 < N) {
                if (room[r + 1][c] == 0) {
                    r++;
                }
            }
        }

        if (d == 3) {
            if (c - 1 >= 0) {
                if (room[r][c - 1] == 0) {
                    c--;
                }
            }
        }
    }
}