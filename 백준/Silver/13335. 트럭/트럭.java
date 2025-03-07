import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int w;
    static int L;
    static int[] arr;

    static class Node {
        int time;
        int weight;

        public Node(int time, int weight) {
            this.time = time;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        LinkedList<Node> q = new LinkedList<>();

        int idx = 1;
        int time = 1;
        while (true) {
            if (!q.isEmpty()) {
                Node node = q.peekFirst();
                if (time - node.time == w) {
                    q.pollFirst();
                    L += node.weight;

                    if (idx > n && q.isEmpty()) break;
                }
            }

            if (idx <= n) {
                int nowWeight = arr[idx];

                if (L >= nowWeight) {
                    q.offerLast(new Node(time, nowWeight));
                    idx++;
                    L -= nowWeight;
                }
            }

            time++;
        }

        System.out.print(time);
    }
}