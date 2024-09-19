import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer tokenizer;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        long[] road = new long[N - 1];
        tokenizer = new StringTokenizer(reader.readLine(), " ");
        for (int i = 0; i < N - 1; i++) {
            road[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int[] city = new int[N];
        tokenizer = new StringTokenizer(reader.readLine(), " ");
        for (int i = 0; i < N; i++) {
            city[i] = Integer.parseInt(tokenizer.nextToken());
        }

        long money = 0;
        long minCity = city[0];
        for (int i = 0; i < N - 1; i++) {
            if (minCity > city[i]) {
                minCity = city[i];
            }

            money += minCity * road[i];
        }

        System.out.print(money);
    }
}