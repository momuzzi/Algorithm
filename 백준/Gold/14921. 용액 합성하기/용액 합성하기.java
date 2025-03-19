import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        int answer = 200_000_001;
        int head = 0;
        int tail = arr.length - 1;
        while (head != tail) {
            int sum = arr[head] + arr[tail];

            if (Math.abs(answer) > Math.abs(sum)) {
                answer = sum;
            }

            if (sum == 0) {
                break;
            }

            if (sum < 0) {
                head++;
            } else {
                tail--;
            }
        }

        System.out.print(answer);
    }
}