import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;

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

        Arrays.sort(arr);
    }

    static void solve() {
        int idxA = 0;
        int idxB = arr.length - 1;
        int nearZero = Integer.MAX_VALUE;
        int answerIdxA = 0;
        int answerIdxB = 0;
        while (idxA != idxB) {
            int sum = arr[idxA] + arr[idxB];

            if (Math.abs(sum) < nearZero) {
                answerIdxA = idxA;
                answerIdxB = idxB;
                nearZero = Math.abs(sum);
            }

            if (sum < 0) {
                idxA++;
            }

            if (sum > 0) {
                idxB--;
            }

            if (sum == 0) {
                break;
            }
        }

        System.out.print(arr[answerIdxA] + " " + arr[answerIdxB]);
    }
}