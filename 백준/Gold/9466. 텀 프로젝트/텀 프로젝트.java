import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static boolean[] visit;
    static boolean[] finish;
    static int[] arr;
    static int cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            arr = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            visit = new boolean[n + 1];
            finish = new boolean[n + 1];

            cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (!visit[j]) {
                    dfs(j);
                }
            }

            sb.append(n - cnt + "\n");
        }

        System.out.print(sb);
    }

    static void dfs(int now) {
        visit[now] = true;

        int next = arr[now];

        if (!visit[next]) {
            dfs(next);
        } else if (!finish[next]) {
            cnt++;

            for (int i = next; i != now; i = arr[i]){
                cnt++;
            }
        }

        finish[now] = true;
    }
}