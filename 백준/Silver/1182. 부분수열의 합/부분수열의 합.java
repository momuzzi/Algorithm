import java.util.*;
import java.io.*;

public class Main {

    static int[] arr;
    static int N;
    static int S;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        S = Integer.parseInt(s[1]);
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bt(0, 0);

        if (S == 0) cnt--;

        System.out.print(cnt);
    }

    static void bt(int start, int sum) {
        if (start == N) {
            if (sum == S) {
                cnt++;
            }
            return;
        }

         bt(start + 1, sum + arr[start]);
         bt(start + 1, sum);
    }
}