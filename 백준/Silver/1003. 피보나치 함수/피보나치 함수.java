import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        StringBuilder builder = new StringBuilder();

        HashMap<Integer, int[]> map = new HashMap<>();
        map.put(0, new int[]{1, 0});
        map.put(1, new int[] {0, 1});

        for (int i = 0; i < num; i++) {
            int N = Integer.parseInt(reader.readLine());
            for (int j = 2; j <= N; j++) {
                int [] dp = new int[2];

                int[] before = map.get(j - 1);
                int[] moreBefore = map.get(j - 2);
                dp[0] = before[0] + moreBefore[0];
                dp[1] = before[1] + moreBefore[1];
                map.put(j, dp);
            }
            int[] result = map.get(N);
            builder.append(result[0]).append(" ").append(result[1]).append("\n");
        }

        System.out.println(builder);
    }
}