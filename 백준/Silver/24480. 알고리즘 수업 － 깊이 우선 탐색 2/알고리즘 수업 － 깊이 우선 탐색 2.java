import java.io.*;
import java.util.*;

public class Main {

    static int N, M, R;
    static List<List<Integer>> graph = new ArrayList<>();
    static int cnt = 1;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NMR = br.readLine().split(" ");
        N = Integer.parseInt(NMR[0]);
        M = Integer.parseInt(NMR[1]);
        R = Integer.parseInt(NMR[2]);

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        arr = new int[N + 1];
        arr[R] = 1;

        for (int i = 0; i < M; i++) {
            String[] uv = br.readLine().split(" ");
            int u = Integer.parseInt(uv[0]);
            int v = Integer.parseInt(uv[1]);

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (List<Integer> list : graph) {
            Collections.sort(list);
        }

        dfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(arr[i] + "\n");
        }

        System.out.print(sb);
    }

    static void dfs(int a) {
        arr[a] = cnt;
        cnt++;

        List<Integer> list = graph.get(a);
        for (int i = list.size() - 1; i >= 0; i--) {
            if (arr[list.get(i)] == 0) {
                dfs(list.get(i));
            }
        }
    }
}