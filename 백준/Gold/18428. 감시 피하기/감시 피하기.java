import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static String[][] graph;
    static boolean ans = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new String[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = st.nextToken();
            }
        }

        bt(0, 0, 0);

        System.out.print(ans ? "YES" : "NO");
    }

    static void bt(int depth, int x, int y) {
        if (ans) return;

        if (depth == 3) {
            if (check()) ans = true;
            return;
        }

        for (int i = x;  i < N; i++) {
            for (int j = (i == x ? y : 0); j < N; j++) {
                if (graph[i][j].equals("X")) {
                    graph[i][j] = "O";
                    bt(depth + 1, j == N - 1 ? i + 1 : i, j == N - 1 ? 0 : j + 1);
                    graph[i][j] = "X";
                }
            }
        }
    }

    static boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j].equals("T")) {
                    int copyX = i - 1;
                    while (copyX >= 0) {
                        if (graph[copyX][j].equals("O")) break;

                        if (graph[copyX][j].equals("S")) return false;

                        copyX--;
                    }

                    copyX = i + 1;
                    while (copyX < N) {
                        if (graph[copyX][j].equals("O")) break;

                        if (graph[copyX][j].equals("S")) return false;

                        copyX++;
                    }

                    int copyY = j - 1;
                    while (copyY >= 0) {
                        if (graph[i][copyY].equals("O")) break;

                        if (graph[i][copyY].equals("S")) return false;

                        copyY--;
                    }

                    copyY = j + 1;
                    while (copyY < N) {
                        if (graph[i][copyY].equals("O")) break;

                        if (graph[i][copyY].equals("S")) return false;

                        copyY++;
                    }
                }
            }
        }

        return true;
    }
}