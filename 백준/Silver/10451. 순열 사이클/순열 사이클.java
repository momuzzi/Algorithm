import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N + 1];
            visit = new boolean[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;
            for (int j = 1; j <= N; j++) {
                if (!visit[j]) {
                    cnt++;
                    dfs(j);
                }
            }

            sb.append(cnt + "\n");
        }

        System.out.print(sb);
    }

    static void dfs(int a) {
        visit[a] = true;

        int next = arr[a];

        if (!visit[next]) {
            dfs(next);
        }
    }
}