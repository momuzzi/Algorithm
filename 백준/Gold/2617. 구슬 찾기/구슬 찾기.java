import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        boolean[][] graph = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            graph[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j) continue;

                    if (graph[i][k] && graph[k][j]) graph[i][j] = true;
                }
            }
        }

        int m = N / 2;
        int[][] ans = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (graph[i][j]) {
                    ans[i][0]++;
                    ans[j][1]++;
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (ans[i][0] > m || ans[i][1] > m) cnt++;
        }

        System.out.print(cnt);
    }
}