import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int L;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        L = Integer.parseInt(input[1]);

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
    }

    static void solve() {
        int canContinue = L - 1;
        int tapeCnt = 1;
        int startLoc = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - startLoc <= canContinue) {
                continue;
            }

            tapeCnt++;
            startLoc = arr[i];
        }

        System.out.print(tapeCnt);
    }
}