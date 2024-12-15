import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long A = Long.parseLong(input[0]);
        long B = Long.parseLong(input[1]);
        long C = Long.parseLong(input[2]);

        System.out.print(func(A, B, C));
    }

    static long func(long a, long b, long c) {
        if (b == 1) {
            return a % c;
        }

        long result = func(a, b / 2, c);
        result = result * result % c;
        if (b % 2 != 0) {
            return result * a % c;
        }

        return result;
    }
}