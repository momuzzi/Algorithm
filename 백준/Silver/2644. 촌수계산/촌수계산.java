import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int a, b;
    static int m;
    static boolean[][] graph;
    static LinkedList<Node> s = new LinkedList<>();

    static class Node {
        int n;
        int cnt;

        public Node(int n, int cnt) {
            this.n = n;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] ab = br.readLine().split(" ");
        a = Integer.parseInt(ab[0]);
        b = Integer.parseInt(ab[1]);
        m = Integer.parseInt(br.readLine());

        graph = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            String[] xy = br.readLine().split(" ");
            graph[Integer.parseInt(xy[0])][Integer.parseInt(xy[1])] = true;
            graph[Integer.parseInt(xy[1])][Integer.parseInt(xy[0])] = true;
        }
    }

    static void solve() {
        s.offerLast(new Node(a, 0));
        System.out.print(dfs());
    }

    static int dfs() {
        while (!s.isEmpty()) {
            Node node = s.pollLast();

            if (node.n == b) {
                return node.cnt;
            }

            for (int i = 1; i <= n; i++) {
                if (graph[node.n][i]) {
                    s.offerLast(new Node(i, node.cnt + 1));
                    graph[node.n][i] = false;
                    graph[i][node.n] = false;
                }
            }
        }

        return -1;
    }
}