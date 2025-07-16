import java.io.*;
import java.util.*;

public class Main {

    static int F, S, G, U, D;
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        arr = new int[F + 1];
        visit = new boolean[F + 1];
        visit[S] = true;
    }

    static void solve() {
        LinkedList<Integer> q = new LinkedList<>();
        q.offerLast(S);

        while (!q.isEmpty()) {
            int pollNum = q.pollFirst();

            if (pollNum == G) {
                System.out.print(arr[pollNum]);
                return;
            }

            for (int i = 1; i <= 2; i++) {
                int moveX = pollNum;
                if (i % 2 == 0) {
                    moveX -= D;
                } else {
                    moveX += U;
                }

                if (moveX > 0 && moveX <= F && !visit[moveX]) {
                    arr[moveX] = arr[pollNum] + 1;
                    visit[moveX] = true;
                    q.offerLast(moveX);
                }
            }
        }

        System.out.print("use the stairs");
    }
}