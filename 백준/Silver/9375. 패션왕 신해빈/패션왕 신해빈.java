import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;
    static int T;

    public static void main(String[] args) throws Exception {
        init();
        for (int i = 0; i < T; i++) {
            solve();
        }
    }

    static void init() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
    }

    static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> m = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] clo = br.readLine().split(" ");

            if (m.containsKey(clo[1])) {
                m.put(clo[1], m.get(clo[1]) + 1);
            } else {
                m.put(clo[1], 1);
            }
        }

        Set<String> keys = m.keySet();

        int cnt = 1;
        for (String s : keys) {
            cnt *= (m.get(s) + 1);
        }

        System.out.println(cnt - 1);
    }
}