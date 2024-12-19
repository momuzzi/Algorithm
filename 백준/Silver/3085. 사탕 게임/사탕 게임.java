import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            char[] cArr = s.toCharArray();
            for (int j = 0; j < N; j++) {
                arr[i][j] = cArr[j];
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j < N - 1) {
                    change(i, j, i, j + 1);
                    int max1 = cal();
                    change(i, j, i, j + 1);
                    result = Math.max(result, max1);
                }

                if (i < N - 1) {
                    change(i, j, i + 1, j);
                    int max2 = cal();
                    change(i, j, i + 1, j);
                    result = Math.max(result, max2);
                }
            }
        }

        System.out.print(result);
    }


    static void change(int a1, int b1, int a2, int b2) {
        char tmp = arr[a1][b1];
        arr[a1][b1] = arr[a2][b2];
        arr[a2][b2] = tmp;
    }

    static int cal() {
        int max = 0;
        for (int i = 0; i < N; i++) {
            int row = 1;
            int col = 1;
            for (int j = 0; j < N - 1; j++) {
                // 행 계산
                if (arr[i][j] == arr[i][j + 1]) {
                    row++;
                } else {
                    max = Math.max(max, row);
                    row = 1;
                }

                // 열 계산
                if (arr[j][i] == arr[j + 1][i]) {
                    col++;
                } else {
                    max = Math.max(max, col);
                    col = 1;
                }
            }

            max = Math.max(max, row);
            max = Math.max(max, col);
        }

        return max;
    }
}