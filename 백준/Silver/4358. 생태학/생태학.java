import java.io.*;
import java.util.*;

public class Main {

    static Map<String, Integer> m = new HashMap<>();
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        init();
        solve();

    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            if (m.containsKey(str)) {
                m.put(str, m.get(str) + 1);
            } else {
                m.put(str, 1);
            }

            cnt++;
        }
    }

    static void solve() {
        List<String> list = new ArrayList<>(m.keySet());
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();

        for (String s : list) {
            int n = m.get(s);
            double percent = (double) n / cnt * 100;
            sb.append(String.format("%s %.4f\n", s, percent));
        }

        System.out.print(sb);
    }
}