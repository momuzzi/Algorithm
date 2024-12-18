import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int B = Integer.parseInt(s[2]);

        int[][] arr = new int[N][M];

        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, arr[i][j]);
                max = Math.max(max, arr[i][j]);
            }
        }

        int resultTime = Integer.MAX_VALUE; // 최소 시간
        int high = 0; // 땅의 최대 높이
        for (int i = min; i <= max; i++) {
            int remove = 0;
            int add = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    int need = arr[j][k] - i;

                    if (need > 0) {
                        remove += need;
                    }

                    if (need < 0) {
                        add += -1 * need;
                    }
                }
            }

            if (add <= B + remove) {
                int time = remove * 2 + add;
                
                if (time < resultTime) {
                    resultTime = time;
                    high = i;
                    continue;
                }
                if (time == resultTime) {
                    high = Math.max(high, i);
                }
            }
        }
        System.out.print(resultTime + " " + high);
    }
}