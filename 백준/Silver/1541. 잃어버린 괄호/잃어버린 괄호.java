import java.io.*;

public class Main {

    static String fx;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        fx = br.readLine();
    }

    static void solve() {
        int firstIdx = 0;
        StringBuilder sb = new StringBuilder();
        while (firstIdx < fx.length() && fx.charAt(firstIdx) != '+' && fx.charAt(firstIdx) != '-') {
            sb.append(fx.charAt(firstIdx));
            firstIdx++;
        }

        String firstNum = sb.toString();

        int sum = Integer.parseInt(firstNum);
        int bracketSum = 0;

        int idx = firstIdx;
        boolean isBracket = false;
        while (idx < fx.length()) {
            char c = fx.charAt(idx);

            if (c == '+') {
                idx++;
                sb = new StringBuilder();

                while (idx < fx.length() && fx.charAt(idx) != '+' && fx.charAt(idx) != '-') {
                    sb.append(fx.charAt(idx));
                    idx++;
                }

                if (isBracket) {
                    bracketSum += Integer.parseInt(sb.toString());
                } else {
                    sum += Integer.parseInt(sb.toString());
                }

                continue;
            }

            if (c == '-') {
                if (!isBracket) {
                    isBracket = true;
                }

                idx++;
                sb = new StringBuilder();

                while (idx < fx.length() && fx.charAt(idx) != '+' && fx.charAt(idx) != '-') {
                    sb.append(fx.charAt(idx));
                    idx++;
                }

                bracketSum += Integer.parseInt(sb.toString());
            }
        }

        System.out.print(sum - bracketSum);
    }
}