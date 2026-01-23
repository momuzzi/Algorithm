import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int idx = 0;
        int num = 0;
        while (idx < s.length()) {
            num++;
            String n = String.valueOf(num);

            for (int i = 0; i < n.length(); i++) {
                if (n.charAt(i) == s.charAt(idx)) {
                    idx++;

                    if (idx == s.length()) break;
                }
            }
        }

        System.out.print(num);
    }
}