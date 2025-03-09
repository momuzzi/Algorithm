import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static PriorityQueue<Integer> gift = new PriorityQueue<>((g1, g2) -> g2 - g1);
    static int[] child;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            gift.offer(Integer.parseInt(st.nextToken()));
        }

        child = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < M; i++) {
            child[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        for (int i = 0; i < M; i++) {
            int giftNum = gift.poll();
            if (giftNum < child[i]) {
                System.out.print(0);
                return;
            }

            gift.offer(giftNum - child[i]);
        }

        System.out.print(1);
    }
}