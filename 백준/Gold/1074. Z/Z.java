import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int r = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);

        System.out.print(func(n, r, c));
    }

    static int func(int n, int r, int c) {
        if (n == 0) {
            return 0;
        }

        int half = (int) Math.pow(2, n - 1);
        int size = half * half;

        if (r < half && c < half) {
            return func(n - 1, r, c);
        }

        if (r < half && c >= half) {
            return size + func(n - 1, r, c - half);
        }

        if (r >= half && c < half) {
            return size * 2 + func(n - 1, r - half, c);
        }

         return size * 3 + func(n - 1, r - half, c - half);
    }
}