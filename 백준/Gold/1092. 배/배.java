import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] craArr;
    static int M;
    static int[] boxArr;
    static boolean[] moveBox;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        craArr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            craArr[i] = -1 * Integer.parseInt(st.nextToken());
        }

        Arrays.sort(craArr);

        M = Integer.parseInt(br.readLine());
        boxArr = new int[M];
        moveBox = new boolean[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            boxArr[i] = -1 * Integer.parseInt(st.nextToken());
        }

        Arrays.sort(boxArr);
    }

    static void solve() {
        if (-boxArr[0] > -craArr[0]) {
            System.out.print(-1);
            return;
        }

        int time = 0;
        int moveCnt = 0;
        while (moveCnt != M) {
            int craIdx = 0;
            int boxIdx = 0;

            while (craIdx < N && boxIdx < M) {
                if (-craArr[craIdx] >= -boxArr[boxIdx] && !moveBox[boxIdx]) {
                    moveBox[boxIdx] = true;
                    moveCnt++;
                    craIdx++;
                    boxIdx++;
                } else {
                    boxIdx++;
                }
            }

            time++;
        }

        System.out.print(time);
    }
}