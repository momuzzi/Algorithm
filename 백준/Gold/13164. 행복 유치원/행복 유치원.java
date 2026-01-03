import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");

        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int[] dif = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            dif[i] = arr[i + 1] - arr[i];
            sum += dif[i];
        }

        Arrays.sort(dif);

        for (int i = N - 2; i > N - 2 - K + 1; i--) {
            sum -= dif[i];
        }

        System.out.print(sum);
    }
}