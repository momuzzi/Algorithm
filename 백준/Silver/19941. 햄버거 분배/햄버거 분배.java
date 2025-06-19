import java.io.*;

public class Main {

    static int N;
    static int K;
    static char[] arr;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        String str = br.readLine();
        arr = str.toCharArray();
    }

    static void solve() {
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean choice = false;
            if (arr[i] == 'P') {
                for (int j = i - K; j <= i - 1; j++) {
                    if (j < 0) {
                        continue;
                    }

                    if (arr[j] == 'H') {
                        arr[j] = 'X';
                        cnt++;
                        choice = true;
                        break;
                    }
                }

                if (choice) continue;

                for (int j = i + 1; j <= i + K; j++) {
                    if (j >= arr.length) {
                        break;
                    }

                    if (arr[j] == 'H') {
                        arr[j] = 'X';
                        cnt++;
                        break;
                    }
                }
            }
        }

        System.out.print(cnt);
    }
}