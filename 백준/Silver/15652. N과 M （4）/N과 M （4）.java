import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] arr;
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

        arr = new int[M];
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

        for (int i = 1; i <= N; i++) {
            if (index == 0) {
                arr[index] = i;
                bt(index + 1);
            } else if (index != 0 && i >= arr[index - 1]) {
                arr[index] = i;
                bt(index + 1);
            }
        }
    }
}