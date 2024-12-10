import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        int cnt = 0;
        
        if (N > 9) {
            cnt += 9;
        } else {
            cnt += N;
            System.out.print(cnt);
            return;
        }

        if (N > 99) {
            cnt += 2 * 90;
        } else {
            cnt += 2 * (N - 10 + 1);
            System.out.print(cnt);
            return;
        }

        if (N > 999) {
            cnt += 3 * 900;
        } else {
            cnt += 3 * (N - 100 + 1);
            System.out.print(cnt);
            return;
        }

        if (N > 9_999) {
            cnt += 4 * 9_000;
        } else {
            cnt += 4 * (N - 1_000 + 1);
            System.out.print(cnt);
            return;
        }

        if (N > 99_999) {
            cnt += 5 * 90_000;
        } else {
            cnt += 5 * (N - 10_000  + 1);
            System.out.print(cnt);
            return;
        }

        if (N > 999_999) {
            cnt += 6 * 900_000;
        } else {
            cnt += 6 * (N - 100_000  + 1);
            System.out.print(cnt);
            return;
        }

        if (N > 9_999_999) {
            cnt += 7 * 9_000_000;
        } else {
            cnt += 7 * (N - 1_000_000  + 1);
            System.out.print(cnt);
            return;
        }

        if (N > 99_999_999) {
            cnt += 8 * 90_000_000;
        } else {
            cnt += 8 * (N - 10_000_000  + 1);
            System.out.print(cnt);
            return;
        }

        if (N == 100_000_000) {
            cnt += 9 * 1;
        }

        System.out.print(cnt);

    }
}