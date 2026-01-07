import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N * N];

        int idx = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[idx] = Integer.parseInt(st.nextToken());
                idx++;
            }
        }

        Arrays.sort(arr);

        System.out.print(arr[N * N - N]);
    }
}