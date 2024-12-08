import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        int num = Integer.parseInt(reader.readLine());

        int T = 2;
        int sum = 0;

        while (true) {
            if (sum > num) {
                T--;

                sum -= T - 1;
                break;
            }

            sum += T - 1;
            T++;
        }

        if (sum == num) {
            T--;
            sum -= T - 1;
        }

        int parent = 0;
        int child = 0;
        int turn = sum + 1;
        int how = num - turn;

        if (T % 2 == 0) {
            parent = 1;
            child = T - 1;

            parent += how;
            child -= how;
        } else {
            parent = T - 1;
            child = 1;

            parent -= how;
            child += how;
        }

        builder.append(child).append("/").append(parent);

        System.out.print(builder);

    }
}