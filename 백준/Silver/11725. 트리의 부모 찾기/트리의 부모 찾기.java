import java.io.*;
import java.util.*;

public class Main {

    static List<List<Integer>> edge;
    static int N;
    static Map<Integer, Integer> map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        map = new HashMap<>();
        N = Integer.parseInt(reader.readLine());
        visited = new boolean[N + 1];
        edge = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            edge.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());

            edge.get(x).add(y);
            edge.get(y).add(x);
        }

        dfs(1);

        for (int i = 2; i <= N; i++) {
            Integer num = map.get(i);
            builder.append(num).append("\n");
        }

        System.out.print(builder);
    }

    static void dfs(int a) {

        visited[a] = true;

        for (int b : edge.get(a)) {
            if (!visited[b]) {
                map.put(b, a);
                dfs(b);
            }
        }
    }
}