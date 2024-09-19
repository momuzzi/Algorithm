import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] s = reader.readLine().split(" ");
            arr[i][0] = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }

                return o1[0] - o2[0];
            }
        });

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                builder.append(arr[i][j]).append(" ");
            }
            builder.append("\n");
        }

        System.out.print(builder);
    }
}