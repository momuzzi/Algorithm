import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int cnt = 0;
    static boolean[] visit;
    static int[] num;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        visit = new boolean[10];
        num = new int[3];

        bt(0);

        System.out.print(cnt);
    }

    static void bt(int depth) {
        if (depth == 3) {
            for (int i = 0; i < N; i++) {
                int n = arr[i][0];
                int s = arr[i][1];
                int b = arr[i][2];

                int m = 100;
                int[] arr2 = new int[3];
                for (int j = 0; j < 3; j++) {
                    arr2[j] = n / m;
                    n %= m;
                    m /= 10;
                }

                int s2 = 0;
                int b2 = 0;
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        if (num[j] == arr2[k]) {
                            if (j == k) {
                                s2++;
                            } else {
                                b2++;
                            }
                        }
                    }
                }

                if (s != s2 || b != b2) return;
            }

            cnt++;
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (!visit[i]) {
                visit[i] = true;
                num[depth] = i;
                bt(depth + 1);
                visit[i] = false;
            }
        }
    }
}