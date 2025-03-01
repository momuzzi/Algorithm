import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static char[][] matrixA;
    static char[][] matrixB;
    static int cnt = 0;

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrixA = new char[N][M];
        matrixB = new char[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            char[] c = s.toCharArray();
            for (int j = 0; j < M; j++) {
                matrixA[i][j] = c[j];
            }
        }

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            char[] c = s.toCharArray();
            for (int j = 0; j < M; j++) {
                matrixB[i][j] = c[j];
            }
        }
    }

    static void solve() {
        for (int i = 0; i <= N - 3; i++) {
            for (int j = 0; j <= M - 3; j++) {
                if (matrixA[i][j] != matrixB[i][j]) {
                    change(i, j);
                    cnt++;
                }
            }
        }
    }

    static void change(int x, int y) {
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                matrixA[i][j] = matrixA[i][j] == '1' ? '0' : '1';
            }
        }
    }

    public static void main(String[] args) throws Exception {
        init();

        if (N < 3 || M < 3) {
            System.out.print(Arrays.deepEquals(matrixA, matrixB) ? 0 : -1);

            return;
        }

        solve();

        System.out.print(Arrays.deepEquals(matrixA, matrixB) ? cnt : -1);
    }
}