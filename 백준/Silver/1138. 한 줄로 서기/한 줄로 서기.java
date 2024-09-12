import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        int[] arr = new int[N];

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            int leftNum = Integer.parseInt(tokenizer.nextToken());

            int emptyCnt = 0;
            for (int j = 0; j < N; j++) {
                if (arr[j] == 0) {
                    if (emptyCnt == leftNum) {
                        arr[j] = i;
                        break;
                    }
                    emptyCnt++;
                }

            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            builder.append(arr[i]).append(" ");
        }

        System.out.print(builder);
    }
}