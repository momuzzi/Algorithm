import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int[] inputArr;
    static boolean[] isUsed;
    static int N;
    static int M;
    static StringBuilder builder;
    static List<int[]> list;

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
        list = new ArrayList<>();

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");

        for (int i = 0; i < N; i++) {
            inputArr[i] = Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.sort(inputArr);

        bt(0);

        for (int[] a : list) {
            for (int i : a) {
                builder.append(i).append(" ");
            }
            builder.append("\n");
        }

        System.out.print(builder);
    }

    static void bt(int index) {
        if (index == M) {
            int[] partArr = new int[M];

            for (int j = 0; j < M; j++) {
                partArr[j] = arr[j];
            }

            boolean isDup = false;
            for (int[] a : list) {
                if (Arrays.equals(a, partArr)) {
                    isDup = true;
                }
            }

            if (!isDup) {
                list.add(partArr);
            }

            return;
        }

        for (int i = 0; i < N ; i++) {
            if (index == 0) {
                if (!isUsed[i]) {
                    isUsed[i] = true;
                    arr[index] = inputArr[i];
                    bt(index + 1);
                    isUsed[i] = false;
                }
            } else if (index != 0 && inputArr[i] >= arr[index - 1]) {
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