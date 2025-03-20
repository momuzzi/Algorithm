import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] craArr;
    static int M;
    static List<Integer> boxList;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        craArr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            craArr[i] = -1 * Integer.parseInt(st.nextToken());
        }

        Arrays.sort(craArr);

        M = Integer.parseInt(br.readLine());
        boxList = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            boxList.add(Integer.parseInt(st.nextToken()));
        }
        
        Collections.sort(boxList, Collections.reverseOrder());
    }

    static void solve() {
        if (boxList.get(0) > -craArr[0]) {
            System.out.print(-1);
            return;
        }

        int time = 0;
        while (!boxList.isEmpty()) {
            int craIdx = 0;
            int boxIdx = 0;

            while (craIdx < N && boxIdx < boxList.size()) {
                if (-craArr[craIdx] >= boxList.get(boxIdx)) {
                    boxList.remove(boxIdx);
                    craIdx++;
                } else {
                    boxIdx++;
                }
            }

            time++;
        }

        System.out.print(time);
    }
}