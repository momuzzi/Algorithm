import java.io.*;
import java.util.*;

public class Main {

    static class Result {
        int rx;
        int ry;
        int bx;
        int by;

        Result(int rx, int ry, int bx, int by) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
        }
    }

    static int N, M;
    static char[][] board;
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        board = new char[N][M];

        int rx = 0;
        int ry = 0;
        int bx = 0;
        int by = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j);

                if (board[i][j] == 'R') {
                    rx = i;
                    ry = j;
                }

                if (board[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }

        bfs(rx, ry, bx, by);

        System.out.print(ans);
    }

    static void bfs(int rx, int ry, int bx, int by) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {rx, ry, bx, by, 0, 4});

        while (!q.isEmpty()) {
            int[] poll = q.poll();

            if (poll[4] == 10) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                if (poll[5] == i) continue;

                Result result = move(i, poll);

                if (board[result.bx][result.by] == 'O') continue;

                if (board[result.rx][result.ry] == 'O') {
                    ans = 1;
                    return;
                }

                q.offer(new int[] {result.rx, result.ry, result.bx, result.by, poll[4] + 1, i});
            }
        }
    }

    static Result move (int d, int[] arr) {
        if (d == 0) {
            return left(arr);
        }

        if (d == 1) {
            return right(arr);
        }

        if (d == 2) {
            return up(arr);
        }

        return down(arr);
    }

    static Result left(int[] arr) {
        int rx = arr[0];
        int ry = arr[1];
        int bx = arr[2];
        int by = arr[3];

        if (rx == bx) {
            if (ry < by) {
                while (true) {
                    if (board[rx][ry - 1] == '#') break;

                    ry--;

                    if (board[rx][ry] == 'O') break;
                }

                while (true) {
                    if (board[bx][by - 1] == '#') break;
                    if (board[bx][by - 1] != 'O' && by - 1 == ry) break;

                    by--;

                    if (board[bx][by] == 'O') break;
                }
            } else {
                while (true) {
                    if (board[bx][by - 1] == '#') break;

                    by--;

                    if (board[bx][by] == 'O') break;
                }

                while (true) {
                    if (board[rx][ry - 1] == '#') break;
                    if (board[rx][ry - 1] != 'O' && ry - 1 == by) break;

                    ry--;

                    if (board[rx][ry] == 'O') break;
                }
            }

        } else {
            while (true) {
                if (board[rx][ry - 1] == '#') break;

                ry--;

                if (board[rx][ry] == 'O') break;
            }

            while (true) {
                if (board[bx][by - 1] == '#') break;

                by--;

                if (board[bx][by] == 'O') break;
            }
        }

        return new Result(rx, ry, bx, by);
    }

    static Result right(int[] arr) {
        int rx = arr[0];
        int ry = arr[1];
        int bx = arr[2];
        int by = arr[3];

        if (rx == bx) {
            if (ry < by) {
                while (true) {
                    if (board[bx][by + 1] == '#') break;

                    by++;

                    if (board[bx][by] == 'O') break;
                }

                while (true) {
                    if (board[rx][ry + 1] == '#') break;
                    if (board[rx][ry + 1] != 'O' && ry + 1 == by) break;

                    ry++;

                    if (board[rx][ry] == 'O') break;
                }
            } else {
                while (true) {
                    if (board[rx][ry + 1] == '#') break;

                    ry++;

                    if (board[rx][ry] == 'O') break;
                }

                while (true) {
                    if (board[bx][by + 1] == '#') break;
                    if (board[bx][by + 1] != 'O' && by + 1 == ry) break;

                    by++;

                    if (board[bx][by] == 'O') break;
                }
            }
        } else {
            while (true) {
                if (board[rx][ry + 1] == '#') break;

                ry++;

                if (board[rx][ry] == 'O') break;
            }

            while (true) {
                if (board[bx][by + 1] == '#') break;

                by++;

                if (board[bx][by] == 'O') break;
            }
        }

        return new Result(rx, ry, bx, by);
    }

    static Result up(int[] arr) {
        int rx = arr[0];
        int ry = arr[1];
        int bx = arr[2];
        int by = arr[3];

        if (ry == by) {
            if (rx < bx) {
                while (true) {
                    if (board[rx - 1][ry] == '#') break;

                    rx--;

                    if (board[rx][ry] == 'O') break;
                }

                while (true) {
                    if (board[bx - 1][by] == '#') break;
                    if (board[bx - 1][by] != 'O' && bx - 1 == rx) break;

                    bx--;

                    if (board[bx][by] == 'O') break;
                }
            } else {
                while (true) {
                    if (board[bx - 1][by] == '#') break;

                    bx--;

                    if (board[bx][by] == 'O') break;
                }

                while (true) {
                    if (board[rx - 1][ry] == '#') break;
                    if (board[rx - 1][ry] != 'O' && rx - 1 == bx) break;

                    rx--;

                    if (board[rx][ry] == 'O') break;
                }
            }
        } else {
            while (true) {
                if (board[rx - 1][ry] == '#') break;

                rx--;

                if (board[rx][ry] == 'O') break;
            }

            while (true) {
                if (board[bx - 1][by] == '#') break;

                bx--;

                if (board[bx][by] == 'O') break;
            }
        }

        return new Result(rx, ry, bx, by);
    }

    static Result down(int[] arr) {
        int rx = arr[0];
        int ry = arr[1];
        int bx = arr[2];
        int by = arr[3];

        if (ry == by) {
            if (rx > bx) {
                while (true) {
                    if (board[rx + 1][ry] == '#') break;

                    rx++;

                    if (board[rx][ry] == 'O') break;
                }

                while (true) {
                    if (board[bx + 1][by] == '#') break;
                    if (board[bx + 1][by] != 'O' && bx + 1 == rx) break;

                    bx++;

                    if (board[bx][by] == 'O') break;
                }
            } else {
                while (true) {
                    if (board[bx + 1][by] == '#') break;

                    bx++;

                    if (board[bx][by] == 'O') break;
                }

                while (true) {
                    if (board[rx + 1][ry] == '#') break;
                    if (board[rx + 1][ry] != 'O' && rx + 1 == bx) break;

                    rx++;

                    if (board[rx][ry] == 'O') break;
                }
            }
        } else {
            while (true) {
                if (board[rx + 1][ry] == '#') break;

                rx++;

                if (board[rx][ry] == 'O') break;
            }

            while (true) {
                if (board[bx + 1][by] == '#') break;

                bx++;

                if (board[bx][by] == 'O') break;
            }
        }

        return new Result(rx, ry, bx, by);
    }
}