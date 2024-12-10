import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        String s = reader.readLine();

        String[] sArr = s.split(" ");
        int N = Integer.parseInt(sArr[0]);
        int M = Integer.parseInt(sArr[1]);

        int[][] intArr = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            for (int j = 1; j <= M; j++) {
                intArr[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        int K = Integer.parseInt(reader.readLine());

        for (int index = 0; index < K; index++) {
            String[] input = reader.readLine().split(" ");
            int i = Integer.parseInt(input[0]);
            int j = Integer.parseInt(input[1]);
            int x = Integer.parseInt(input[2]);
            int y = Integer.parseInt(input[3]);

            int sum = 0;
            for (int a = i; a <= x; a++) {
                for (int b = j; b <= y; b++) {
                    sum += intArr[a][b];
                }
            }

            builder.append(sum).append("\n");
        }

        System.out.print(builder);
    }
}