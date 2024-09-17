import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int[] inputArr;
    static boolean[] isUsed;
    static int N;
    static int M;
    static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        builder = new StringBuilder();
        String str = reader.readLine();
        String[] s = str.split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        inputArr = new int[N];
        arr = new int[M];
        isUsed = new boolean[N];

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        for (int i = 0; i < N; i++) {
            inputArr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(inputArr);

        bt(0);

        System.out.print(builder);
    }

    static void bt(int index) {
        if (index == M) {
            for (int num : arr) {
                builder.append(num).append(" ");
            }
            builder.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (index == 0) {
                isUsed[i] = true;
                arr[index] = inputArr[i];
                bt(index + 1);
                isUsed[i] = false;
            } else if (index != 0 && inputArr[i] > arr[index - 1]) {
                if (!isUsed[i]) {
                    isUsed[i] = true;
                    arr[index] = inputArr[i];
                    bt(index + 1);
                    isUsed[i] = false;
                }
            }
        }
    }
}