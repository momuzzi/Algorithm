import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<Integer> aList;
    static List<Integer> bList;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        aList = new ArrayList<>();
        bList = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            aList.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(aList);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            bList.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(bList);
    }

    static void solve() {
        int S = 0;
        for (int i = 0; i < N; i++) {
            S += aList.get(i) * bList.get(N - 1 - i);
        }

        System.out.print(S);
    }
}