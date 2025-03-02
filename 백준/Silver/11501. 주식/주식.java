import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static int T;
    static int[] arr;
    static Map<Integer, Integer> map;
    static List<Integer> list;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
    }

    static void solve() throws Exception {
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            // 주가 가격, 갯수
            map = new HashMap<>();

            arr = new int[N];

            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                arr[j] = value;

                if (map.containsKey(value)) {
                    map.put(value, map.get(value) + 1);
                } else {
                    map.put(value, 1);
                }
            }

            Set<Integer> keySet = map.keySet();
            list = new ArrayList<>(keySet);

            list.sort(Comparator.reverseOrder());

            long result = calculate(N);
            System.out.println(result);
        }
    }

    static long calculate(int N) {
        long gain = 0l;
        long buyCnt = 0l;
        long buyTotalValue = 0l;
        int maxValueListIdx = 0;
        for (int i = 0; i < N; i++) {
            int maxValue = 0;

            while (true) {
                maxValue = list.get(maxValueListIdx);

                if (map.get(maxValue) == 0) {
                    maxValueListIdx++;
                } else {
                    break;
                }
            }

            int todayPrice = arr[i];
            if (todayPrice < maxValue) {
                buyTotalValue += todayPrice;
                buyCnt++;

                map.put(todayPrice, map.get(todayPrice) - 1);
                continue;
            }

            if (todayPrice == maxValue) {
                if (buyCnt > 0) {
                    gain += todayPrice * buyCnt - buyTotalValue;

                    buyCnt = 0;
                    buyTotalValue = 0;
                }

                int maxValueCnt = map.get(maxValue);
                map.put(maxValue, maxValueCnt - 1);

                if (map.get(maxValue) == 0) {
                    if (list.size() > maxValueListIdx + 1) {
                        maxValueListIdx++;
                    }
                }
            }
        }

        return gain;
    }
}