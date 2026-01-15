import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static List<List<int[]>> graph = new ArrayList<>();
    static int farNode = -1;
    static int dist = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            graph.get(p).add(new int[] {c, m});
            graph.get(c).add(new int[] {p, m});
        }

        dfs(1);

        dist = -1;
        dfs(farNode);

        System.out.print(dist);
    }

    static void dfs(int start) {
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[] {start, 0});
        boolean[] visit = new boolean[n + 1];
        visit[start] = true;

        while (!stack.isEmpty()) {
            int[] pop = stack.pop();

            if (pop[1] > dist) {
                dist = pop[1];
                farNode = pop[0];
            }

            List<int[]> nexts = graph.get(pop[0]);

            for (int[] next : nexts) {
                if (!visit[next[0]]) {
                    visit[next[0]] = true;
                    stack.push(new int[] {next[0], pop[1] + next[1]});
                }
            }
        }
    }
}