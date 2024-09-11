import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] graph;
    static boolean[] visited;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= M; i++) {
            String str = reader.readLine();
            String[] strArray = str.split(" ");
            int x = Integer.parseInt(strArray[0]);
            int y = Integer.parseInt(strArray[1]);
            graph[x][y] = graph[y][x] = true;
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                cnt++;
            }
        }

        System.out.print(cnt);
    }

    static void dfs(int vertex) {
        visited[vertex] = true;

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && graph[vertex][i]) {
                dfs(i);
            }
        }
    }
}