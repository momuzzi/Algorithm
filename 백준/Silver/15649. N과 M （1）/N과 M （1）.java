import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] arr;
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

        arr = new int[M]; // [0 ~ M - 1] : M개만큼 선택해서 배열을 구성한다.
        isUsed = new boolean[N + 1]; //[1 ~ N] : 1부터 N까지의 정수 중 배열에 넣은 정수는 사용한 표시를 한다.

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
            if (!isUsed[i]) {
                isUsed[i] = true;
                arr[index] = i;
                bt(index + 1);
                isUsed[i] = false;
            }
        }
    }
}