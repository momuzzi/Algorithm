import java.io.*;
import java.util.*;

public class Main {

    static int A;
    static int B;
    static int N;
    static int M;
    static int[] arr = new int[100001];
    static int[] dx;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        dx = new int[] {-1, 1, -A, A, -B, B, -A, A, -B, B};
    }

    static void solve() {
        LinkedList<Integer> q = new LinkedList<>();
        q.offerLast(N);

        while (!q.isEmpty()) {
            int nowX = q.pollFirst();

            if (nowX == M) {
                System.out.print(arr[nowX]);
                return;
            }

            for (int i = 0; i < dx.length; i++) {
                int moveX;
                if (i < 6) {
                    moveX = nowX + dx[i];
                } else {
                    moveX = nowX * dx[i];
                }

                if (moveX < 0 || moveX > 100000) continue;

                if (arr[moveX] != 0) continue;

                arr[moveX] = arr[nowX] + 1;
                q.offerLast(moveX);
            }
        }
    }
}