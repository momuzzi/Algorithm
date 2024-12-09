import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        int N = Integer.parseInt(reader.readLine());

        int[][] whArray = new int[N][2];

        int[] cnt = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            whArray[i][0] = Integer.parseInt(tokenizer.nextToken());
            whArray[i][1] = Integer.parseInt(tokenizer.nextToken());

            for (int j = 0; j <= i; j++) {
                if (whArray[j][0] > whArray[i][0] && whArray[j][1] > whArray[i][1]) {
                    cnt[i]++;
                }

                if (whArray[j][0] < whArray[i][0] && whArray[j][1] < whArray[i][1]) {
                    cnt[j]++;
                }
            }
        }

        for (int num : cnt) {
            builder.append(num + 1).append("\n");
        }

        System.out.print(builder);
    }
}