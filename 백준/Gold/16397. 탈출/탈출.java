import java.io.*;
import java.util.*;

public class Main {

    static int N, T, G;
    static boolean[] visit = new boolean[100_000];

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
    }

    static void solve() {
        LinkedList<int[]> q = new LinkedList<>();
        q.offerLast(new int[] {N, 0});
        visit[N] = true;

        while (!q.isEmpty()) {
            int[] poll = q.pollFirst();

            if (poll[1] == T + 1) {
                System.out.print("ANG");
                return;
            }

            if (poll[0] == G) {
                System.out.print(poll[1]);
                return;
            }

            for (int i = 0; i < 2; i++) {
                int nextNum = 0;
                if (i == 0) {
                    nextNum = A(poll[0]);
                } else {
                    nextNum = B(poll[0]);

                    if (nextNum == -1) continue;
                }

                if (nextNum > 99_999 || nextNum < 0) continue;

                if (visit[nextNum]) continue;

                q.offerLast(new int[] {nextNum, poll[1] + 1});
                visit[nextNum] = true;
            }
        }

        System.out.print("ANG");
    }

    static int A(int num) {
        return num + 1;
    }

    static int B(int num) {
        if (num == 0) return num;

        if (num * 2 > 99_999) return -1;

        int newNum = num * 2;

        String str = String.valueOf(newNum);
        char[] arr = str.toCharArray();

        arr[0] = (char) (arr[0] - 1);

        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result += String.valueOf(arr[i]);
        }

        return Integer.parseInt(result);
    }
}