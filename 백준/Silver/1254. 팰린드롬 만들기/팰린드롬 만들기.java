import java.io.*;

public class Main {
    static String s;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();

        int idx = s.length() - 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (isPelin(i)) {
                idx = i;
            }
        }

        System.out.print(s.length() + idx);
    }

    static boolean isPelin(int i) {
        int left = i;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;

            left++;
            right--;
        }

        return true;
    }
}