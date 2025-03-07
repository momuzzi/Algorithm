import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static String[] arr;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, (o1, o2) -> o1.length() - o2.length());
    }

    static void solve() {
        int answer = N;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (arr[j].startsWith(arr[i])) {
                    answer--;
                    break;
                }
            }
        }

        System.out.print(answer);
    }
}