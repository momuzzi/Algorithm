import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        Set<Integer> twoSum = new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                if (arr[i] + arr[j] >= arr[N - 1]) break;

                twoSum.add(arr[i] + arr[j]);
            }
        }

        List<Integer> list = new ArrayList<>(twoSum);
        Collections.sort(list);

        for (int i = N - 1; i >= 0; i--) {
            int k = arr[i];
            for (int j = N - 1; j >= 0; j--) {
                int z = arr[j];

                if (k - z <= 0) continue;

                int l = 0;
                int h = list.size() - 1;
                while (l <= h) {
                    int m = (l + h) / 2;

                    if (list.get(m) > k - z) {
                        h = m - 1;
                    } else if (list.get(m) < k - z) {
                        l = m + 1;
                    } else {
                        System.out.print(k);
                        return;
                    }
                }
            }
        }
    }
}