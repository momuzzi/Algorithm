import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    final static int SIZE = 1001;
    static boolean edge[][];
    static boolean visited[];
    static LinkedList<Integer> queue;
    static int vertexNum;
    static int edgeNum;
    static int startVertex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        vertexNum = Integer.parseInt(st.nextToken());
        edgeNum = Integer.parseInt(st.nextToken());
        startVertex = Integer.parseInt(st.nextToken());

        edge = new boolean[SIZE][SIZE];
        visited = new boolean[SIZE];

        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            edge[x][y] = edge[y][x] = true;
        }

        dfs(startVertex);
        System.out.println();
        bfs(startVertex);
    }

    static void dfs(int idx) {
        System.out.print(idx + " ");
        visited[idx] = true;
        for (int i = 1; i <= vertexNum; i++)
            if (!visited[i] && edge[idx][i])
                dfs(i);
    }

    static void bfs(int startVertex) {
        queue = new LinkedList<>();
        visited = new boolean[SIZE];

        queue.add(startVertex);
        visited[startVertex] = true;

        while (!queue.isEmpty()) {
            int idx = queue.poll();
            System.out.print(idx + " ");
            for (int i = 1; i <= vertexNum; i++)
                if (!visited[i] && edge[idx][i]) {
                    visited[i] = true;
                    queue.add(i);
                }
        }
    }
}