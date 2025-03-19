import java.io.*;

public class Main {

    static String S;
    static String T;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();
    }

    static void solve() {
        // T가 S가 될 수 있는지 확인
        int idx = T.length() - 1;
        int iterCnt = T.length() - S.length();
        for (int i = 0; i < iterCnt; i++) {
            if (T.charAt(idx) == 'A') {
                T = T.substring(0, idx);
            } else {
                T = T.substring(0, idx);
                T = new StringBuilder(T).reverse().toString();
            }

            idx--;
        }

        if (S.equals(T)) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }
    }
}