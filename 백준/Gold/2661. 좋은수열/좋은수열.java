import java.io.*;

public class Main {

    static int N;
    static String ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        bt(1, "1");

        System.out.print(ans);
    }

    static void bt(int depth, String s) {
        if (ans != null) return;

        if (depth == N) {
            ans = s;
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (can(s + i)) {
                bt(depth + 1, s + i);
            }
        }
    }

    static boolean can(String s) {
        int size = s.length() / 2;

        for (int i = 1; i <= size; i++) {
            int right = s.length() - 1;
            int left = right - i;

            boolean flag = true;
            for (int j = 0; j < i; j++) {
                if (s.charAt(right) != s.charAt(left)) {
                    flag = false;
                    break;
                }

                right--;
                left--;
            }

            if (flag) return false;
        }

        return true;
    }
}