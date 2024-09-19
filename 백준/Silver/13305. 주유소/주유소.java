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
        int minCity = city[0];
        for (int i = 1; i < N - 1; i++) {
            if (minCity > city[i]) {
                money += city[i] * road[i];
                minCity = city[i];
            } else {
                money += minCity * road[i];
            }
        }

        System.out.print(money);
    }
}