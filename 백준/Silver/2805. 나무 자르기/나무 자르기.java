import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] s = reader.readLine().split(" ");
        long N = Long.parseLong(s[0]);
        long M = Long.parseLong(s[1]);

        List<Long> list = new ArrayList<>();

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");

        long min = 0;
        long max = 0;
        for (int i = 0; i < N; i++) {
            long h = Long.parseLong(tokenizer.nextToken());
            list.add(h);

            if (max < h) {
                max = h;
            }
        }

        while (min <= max) {
            long mid = (min + max) / 2;

            long sum = 0;
            for (long h : list) {
                if (h > mid) {
                    sum += h - mid;
                }
            }

            if (sum < M) {
                max = mid - 1;
                continue;
            }

            if (sum >= M) {
                min = mid + 1;
            }
        }

        System.out.print(max);
    }
}