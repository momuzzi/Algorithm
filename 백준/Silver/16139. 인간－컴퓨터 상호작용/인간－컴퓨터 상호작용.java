import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String S;
    static int q;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        S = br.readLine();
        q = Integer.parseInt(br.readLine());
    }

    static void solve() throws Exception {
        int[][] arr = new int[S.length()][26];
        arr[0][S.charAt(0) - 'a'] = 1;

        for (int i = 1; i < S.length(); i++) {
            int idx = S.charAt(i) - 'a';
            arr[i][idx] = arr[i - 1][idx] + 1;
            for (int j = 0; j < 26; j++) {
                if (j == idx) continue;
                arr[i][j] = arr[i - 1][j];
            }
        }

        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int alphaIdx = st.nextToken().charAt(0) - 'a';
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            if (l == 0 && r == 0) {
                System.out.println(arr[0][alphaIdx]);
                continue;
            }

            if (l == 0) {
                System.out.println(arr[r][alphaIdx]);
                continue;
            }

            System.out.println(arr[r][alphaIdx] - arr[l - 1][alphaIdx]);
        }
    }
}