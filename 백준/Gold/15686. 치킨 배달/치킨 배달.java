import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static List<int[]> chicList = new ArrayList<>(); // 치킨집 좌표
    static List<int[]> homeList = new ArrayList<>(); // 집 좌표
    static boolean[] chicVisit;
    static int[] selectChic;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());

                if (num == 1) {
                    homeList.add(new int[] {i, j});
                    continue;
                }

                if (num == 2) {
                    chicList.add(new int[] {i, j});
                }
            }
        }

        chicVisit = new boolean[chicList.size()];
        selectChic = new int[M];
    }

    static void solve() {
        dfs(0, 0);
        System.out.print(min);
    }

    static void dfs(int idx, int depth) {
        if (depth == M) {
            calculate();
            return;
        }

        for (int i = idx; i < chicList.size(); i++) {
            if (!chicVisit[i]) {
                chicVisit[i] = true;
                selectChic[depth] = i; //선택된 치킨집은 리스트의 인덱스를 저장
                dfs(i + 1, depth + 1);
                chicVisit[i] = false;
            }
        }
    }

    static void calculate() {
        int sum = 0;
        for (int i = 0; i < homeList.size(); i++) {
            int[] homeLocation = homeList.get(i);
            int thisMin = Integer.MAX_VALUE;
            for (int j = 0 ; j < selectChic.length; j++) {
                int chickListIdx = selectChic[j];
                int[] chickenLocation = chicList.get(chickListIdx);

                thisMin = Math.min(thisMin, Math.abs(homeLocation[0] - chickenLocation[0]) + Math.abs(homeLocation[1] - chickenLocation[1]));
            }

            sum += thisMin;

            if (sum >= min) return;
        }

        min = Math.min(min, sum);
    }
}