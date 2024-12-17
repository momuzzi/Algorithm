import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static Deque<int[]> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] s = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);

            arr = new int[10];
            q = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                int pn = Integer.parseInt(st.nextToken());
                arr[pn] += 1;
                q.addLast(new int[] {pn, j - 1}); // 중요도, 인덱스 위치(M)
            }

            int cnt = 0;
            while (true) {
                int[] poll = q.pollFirst();
                int pn = poll[0];

                boolean flag = false;
                for (int k = pn + 1; k <= 9; k++) {
                    if (arr[k] > 0) {
                        q.addLast(poll);
                        flag = true;
                        break;
                    }
                }

                if (flag) {
                    continue;
                }

                cnt++;
                arr[pn] -= 1;
                if (poll[1] == M) {
                    break;
                }
            }
            sb.append(cnt + "\n");
        }
        System.out.print(sb);
    }
}