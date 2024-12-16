import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int cnt;
    static boolean[] arr;
    static boolean[] upArr;
    static boolean[] downArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new boolean[N];
        upArr = new boolean[2 * N - 1];
        downArr = new boolean[2 * N - 1];

        bt(0);

        System.out.print(cnt);
    }

    static void bt(int idx) {
        if (idx == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!arr[i] && !upArr[idx + i] && !downArr[N - 1 + idx - i]) {
                arr[i] = true;
                upArr[idx + i] = true;
                downArr[N - 1 + idx - i] = true;
                bt(idx + 1);
                arr[i] = false;
                upArr[idx + i] = false;
                downArr[N - 1 + idx - i] = false;
            }
        }
    }
}