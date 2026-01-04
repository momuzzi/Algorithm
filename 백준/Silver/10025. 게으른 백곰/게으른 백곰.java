import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);

        int[] arr = new int[1_000_001];

        int maxX = 0;
        for (int i = 0; i < N; i++) {
            String[] gx = br.readLine().split(" ");
            int g = Integer.parseInt(gx[0]);
            int x = Integer.parseInt(gx[1]);

            maxX = Math.max(maxX, x);
            arr[x] = g;
        }

        int max = 0;
        for (int i = 0; i <= 2 * K; i++) {
            if (i > maxX) break;
            max += arr[i];
        }

        int sum = max;
        int left = 1;
        int right = 2 * K + 1;
        while (right <= maxX) {
            sum -= arr[left - 1];
            sum += arr[right];

            max = Math.max(max, sum);

            left++;
            right++;
        }

        System.out.print(max);
    }
}