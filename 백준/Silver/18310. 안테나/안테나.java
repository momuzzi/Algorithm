import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (!set.contains(n)) {
                set.add(n);
                list.add(n);
            }

            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        Collections.sort(list);

        long dist = 0;
        for (int i = 1; i < list.size(); i++) {
            dist += (list.get(i) - list.get(0)) * map.get(list.get(i));
        }

        long minDist = dist;
        int ans = list.get(0);
        int homeIdx = 1;
        int leftCnt = map.get(list.get(0));
        int rightCnt = N - map.get(list.get(0));
        while (homeIdx < list.size()) {
            long nowDist = dist;

            nowDist += leftCnt * (list.get(homeIdx) - list.get(homeIdx - 1));
            nowDist -= rightCnt * (list.get(homeIdx) - list.get(homeIdx - 1));

            if (nowDist < minDist) {
                minDist = nowDist;
                ans = list.get(homeIdx);
            }

            dist = nowDist;

            leftCnt += map.get(list.get(homeIdx));
            rightCnt -= map.get(list.get(homeIdx));
            homeIdx++;
        }

        System.out.print(ans);
    }
}