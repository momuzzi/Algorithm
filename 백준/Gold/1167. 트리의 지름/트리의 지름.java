import java.io.*;
import java.util.*;

public class Main {

    static int V;
    static List<List<int[]>> graph = new ArrayList<>();
    static int farNode = -1;
    static int dist = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            while (true) {
                int a = Integer.parseInt(st.nextToken());

                if (a == - 1) break;

                int m = Integer.parseInt(st.nextToken());

                graph.get(n).add(new int[] {a, m});
            }
        }

        dfs(1);

        dist = -1;
        dfs(farNode);

        System.out.print(dist);
    }

    static void dfs(int start) {
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[] {start, 0});
        boolean[] visit = new boolean[V + 1];
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