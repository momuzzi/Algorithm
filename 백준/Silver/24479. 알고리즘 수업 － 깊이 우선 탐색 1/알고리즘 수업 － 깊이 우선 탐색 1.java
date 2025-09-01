import java.io.*;
import java.util.*;

public class Main {

    static List<List<Integer>> list;
    static boolean[] visit;
    static int[] turn;

    static int N, M, R;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        visit = new boolean[N + 1];
        turn = new int[N + 1];

        for (int i = 0; i < M; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (int i = 1; i <= N; i++) {
            List<Integer> getList = list.get(i);
            getList.sort((a, b) -> Integer.compare(b, a));
        }
    }

    static void solve() {
        int cnt = 0;
        LinkedList<Integer> s = new LinkedList<>();
        s.offerLast(R);

        while (!s.isEmpty()) {
            int poll = s.pollLast();

            if (visit[poll]) continue;
            visit[poll] = true;

            cnt++;
            turn[poll] = cnt;

            List<Integer> toList = list.get(poll);
            for (Integer i : toList) {
                if(!visit[i]) {
                    s.offerLast(i);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(turn[i]);
        }
    }
}