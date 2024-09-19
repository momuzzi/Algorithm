import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int cnt = 0;
    static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        builder = new StringBuilder();

        int n = Integer.parseInt(reader.readLine());

        hanoi(n, 1, 2, 3);
        System.out.println(cnt);
        System.out.print(builder);
    }

    static void hanoi(int n, int start, int mid, int end) {
        if (n == 1) {
            builder.append(start).append(" ").append(end).append("\n");
            cnt++;
            return;
        }

        hanoi(n - 1, start, end, mid);
        builder.append(start).append(" ").append(end).append("\n");
        cnt++;
        hanoi(n - 1, mid, start, end);
    }
}