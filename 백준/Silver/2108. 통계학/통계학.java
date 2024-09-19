import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        int N = Integer.parseInt(reader.readLine());

        int[] arr = new int[N];

        Map<Integer, Integer> map = new HashMap<>();

        int plus = 0;
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(reader.readLine());
            arr[i] = n;

            plus += n;

            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }

        // 산술 평균
        int sp = (int) Math.round((double) plus / N);

        Arrays.sort(arr);

        int midNum = arr[N / 2];

        // 최빈값
        int MaxCnt = 0;
        List<Integer> mostList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            Integer thisCnt = entry.getValue();
            Integer key = entry.getKey();
            if (MaxCnt < thisCnt) {
                MaxCnt = thisCnt;
                mostList.clear();
                mostList.add(key);
            } else if (MaxCnt == thisCnt) {
                mostList.add(key);
            }
        }

        Collections.sort(mostList);
        int most = mostList.size() > 1 ? mostList.get(1) : mostList.get(0);

        // 범위
        int range = arr[N - 1] - arr[0];

        builder.append(sp).append("\n").append(midNum).append("\n").append(most).append("\n").append(range);

        System.out.print(builder);
    }
}