import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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
            for (int j = 0; j < 26; j++) {
                arr[i][j] = arr[i - 1][j];
            }

            int idx = S.charAt(i) - 'a';
            arr[i][idx] += 1;
        }

        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int alphaIdx = st.nextToken().charAt(0) - 'a';
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            if (l == 0) {
                bw.write(arr[r][alphaIdx] + "\n");
            } else {
                bw.write((arr[r][alphaIdx] - arr[l - 1][alphaIdx]) + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}