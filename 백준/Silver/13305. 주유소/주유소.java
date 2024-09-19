import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer tokenizer;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        int[] road = new int[N - 1];
        tokenizer = new StringTokenizer(reader.readLine(), " ");
        for (int i = 0; i < N - 1; i++) {
            road[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int[] city = new int[N];
        tokenizer = new StringTokenizer(reader.readLine(), " ");
        for (int i = 0; i < N; i++) {
            city[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int money = city[0] * road[0];
        for (int i = 1; i < N - 1; i++) {
            if (city[i - 1] > city[i]) {
                money += city[i] * road[i];
            } else {
                money += city[i - 1] * road[i];
            }
        }

        System.out.print(money);
    }
}