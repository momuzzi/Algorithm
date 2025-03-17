import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static List<Assign> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static class Assign {
        int needDay;
        int until;

        public Assign(int needDay, int until) {
            this.needDay = needDay;
            this.until = until;
        }
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Assign(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
    }

    static void solve() {
        list.sort((a1, a2) -> a2.until - a1.until);

        int lastDay = list.get(0).until;
        int idx = 0;
        while (idx < n) {
            Assign assign = list.get(idx);
            if (lastDay <= assign.until) {
                lastDay -= assign.needDay;
                idx++;
                continue;
            }

            lastDay--;
        }

        System.out.print(lastDay);
    }
}