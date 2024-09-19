import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        int T = Integer.parseInt(reader.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(reader.readLine());
            int[][] arr = new int[N][2];
            for (int j = 0; j < N; j++) {
                String[] s = reader.readLine().split(" ");
                arr[j][0] = Integer.parseInt(s[0]);
                arr[j][1] = Integer.parseInt(s[1]);
            }

            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            int a = arr[0][1];
            int pass = 1; // 합격자수
            for (int k = 1; k < N; k++) {
                if (a > arr[k][1]) {
                    pass++;
                    a = arr[k][1];
                }
            }

            builder.append(pass).append("\n");
        }
        System.out.print(builder);
    }
}