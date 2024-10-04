import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(tokenizer.nextToken());
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        StringBuilder builder = new StringBuilder();
        int M = Integer.parseInt(reader.readLine());
        tokenizer = new StringTokenizer(reader.readLine(), " ");
        
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(tokenizer.nextToken());
            if (map.containsKey(num)) {
                builder.append(map.get(num)).append(" ");
            } else {
                builder.append(0).append(" ");
            }
        }

        System.out.print(builder);
    }
}