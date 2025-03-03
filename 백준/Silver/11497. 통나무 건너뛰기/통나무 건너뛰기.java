import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;
    static int T;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
    }

    static void solve() throws Exception {
        int[] arr;
        int[] newArr;
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N];
            newArr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int front = 0;
            int end = N - 1;
            for (int j = 0; j < N; j++) {
                if (j % 2 == 0) {
                    newArr[front] = arr[j];
                    front++;
                    continue;
                }

                newArr[end] = arr[j];
                end--;
            }

            int answer = Math.abs(newArr[0] - newArr[N - 1]);
            for (int j = 1; j < N; j++) {
                answer = Math.max(answer, Math.abs(newArr[j - 1] - newArr[j]));
            }

            System.out.println(answer);
        }
    }
}