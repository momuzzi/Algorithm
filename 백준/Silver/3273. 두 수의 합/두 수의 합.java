import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;

    static int x;
    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        x = Integer.parseInt(br.readLine());
    }

    static void solve() {
        Arrays.sort(arr);

        int answer = 0;
        int idxA = 0;
        int idxB = 1;
        while (true) {
            if (idxB == arr.length) {
                idxA++;
                idxB = idxA + 1;
                continue;
            }

            if (idxA == arr.length) {
                break;
            }

            int sum = arr[idxA] + arr[idxB];

            if (sum > x) {
                idxA++;
                idxB = idxA + 1;
                continue;
            }

            if (sum < x) {
                idxB++;
                continue;
            }

            if (sum == x) {
                answer++;
                idxA++;
                idxB = idxA + 1;
            }
        }

        System.out.print(answer);
    }
}