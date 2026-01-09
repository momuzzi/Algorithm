import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            List<List<Integer>> lists = new ArrayList<>();

            for (int j = 0; j < 26; j++) {
                lists.add(new ArrayList<>());
            }

            for (int j = 0; j < W.length(); j++) {
                char c = W.charAt(j);

                lists.get(c - 'a').add(j);
            }

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < 26; j++) {
                List<Integer> list = lists.get(j);

                if (list.size() < K) continue;

                int left = 0;
                int right = K - 1;
                while (right < list.size()) {
                    int length = list.get(right) - list.get(left) + 1;
                    min = Math.min(min, length);
                    max = Math.max(max, length);

                    left++;
                    right++;
                }
            }

            if (min == Integer.MAX_VALUE) {
                sb.append(-1 + "\n");
            } else {
                sb.append(min + " " + max + "\n");
            }
        }

        System.out.print(sb);
    }
}