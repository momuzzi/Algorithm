import java.io.*;
import java.util.*;

public class Main {

    static int k;
    static String min;
    static String max;
    static boolean[] use = new boolean[10];
    static String[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        min = "9".repeat(k + 1);
        max = "0".repeat(k + 1);

        arr = new String[k];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < k; i++) {
            arr[i] = st.nextToken();
        }

        for (int i = 0; i < 10; i++) {
            use[i] = true;
            bt(1, String.valueOf(i), i);
            use[i] = false;
        }

        System.out.print(max + "\n" + min);
    }

    static void bt(int depth, String s, int beforeNum) {
        if (depth == k + 1) {
            if (s.compareTo(min) < 0) {
                min = s;
            }

            if (max.compareTo(s) < 0) {
                max = s;
            }

            return;
        }

        String b = arr[depth - 1];

        if (b.equals("<")) {
            for (int i = beforeNum + 1; i < 10; i++) {
                if (!use[i]) {
                    use[i] = true;
                    bt(depth + 1, s + i, i);
                    use[i] = false;
                }
            }
        } else {
            for (int i = beforeNum - 1; i >= 0; i--) {
                if (!use[i]) {
                    use[i] = true;
                    bt(depth + 1, s + i, i);
                    use[i] = false;
                }
            }
        }
    }
}