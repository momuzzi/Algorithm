import java.io.*;
import java.util.*;

public class Main {

    static int N, K, L;
    static boolean[][] board;
    static boolean[][] snake;
    static char[] lArr = new char[10001];
    static int d = 0;
    static int r = 1;
    static int c = 1;
    static LinkedList<Location> dq = new LinkedList<>();

    static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new boolean[N + 1][N + 1];
        snake = new boolean[N + 1][N + 1];

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            String[] input = br.readLine().split(" ");
            board[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = true;
        }

        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            String[] input = br.readLine().split(" ");
            lArr[Integer.parseInt(input[0])] = input[1].charAt(0);
        }

        dq.offerLast(new Location(1, 1));
        snake[1][1] = true;
    }

    static void solve() throws Exception{
        int timeStamp = 0;
        while (true) {
            if (lArr[timeStamp] == 'L') {
                turnLeft();
            }

            if (lArr[timeStamp] == 'D') {
                turnRight();
            }

            if (goOneBlock()) {
                dq.offerFirst(new Location(r, c));
                snake[r][c] = true;
                if (board[r][c]) {
                    board[r][c] = false; 
                } else {
                    Location tail = dq.pollLast();
                    snake[tail.x][tail.y] = false;
                }
            } else {
                break;
            }

            timeStamp++;
        }

        System.out.print(timeStamp + 1);
    }

    static void turnLeft() {
        if (d == 0) {
            d = 3;
            return;
        }

        d--;
    }

    static void turnRight() {
        if (d == 3)  {
            d = 0;
            return;
        }

        d++;
    }

    static boolean goOneBlock() throws Exception {
        if (d == 0) {
            if (c + 1 <= N && !snake[r][c + 1]) {
                c++;
                return true;
            }

            return false;
        }

        if (d == 1) {
            if (r + 1 <= N && !snake[r + 1][c]) {
                r++;
                return true;
            }

            return false;
        }

        if (d == 2) {
            if (c - 1 >= 1 && !snake[r][c - 1]) {
                c--;
                return true;
            }

            return false;
        }

        if (d == 3) {
            if (r - 1 >= 1 && !snake[r - 1][c]) {
                r--;
                return true;
            }

            return false;
        }

        throw new Exception("d 예외");
    }
}