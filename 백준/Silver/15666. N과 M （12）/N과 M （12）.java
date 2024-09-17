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
        isUsed = new boolean[N];
        inputArr = new int[N];
        arr = new int[M];

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");

        inputArr[0] = Integer.parseInt(tokenizer.nextToken());

        for (int i = 1; i < N; i++) {
            boolean isDup = false;
            int num = Integer.parseInt(tokenizer.nextToken());
            for (int j = 0; j < inputArr.length; j++) {
                if (inputArr[j] == num) {
                    isDup = true;
                }
            }
            if (!isDup) {
                inputArr[i] = num;
            }
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

        for (int i = 0; i < N ; i++) {
            if (index != 0) {
                if (inputArr[i] != 0 && inputArr[i] >= arr[index - 1]) {
                    arr[index] = inputArr[i];
                    bt(index + 1);
                }
            } else if (index == 0) {
                if (inputArr[i] != 0) {
                    arr[index] = inputArr[i];
                    bt(index + 1);
                }
            }
        }
    }
}