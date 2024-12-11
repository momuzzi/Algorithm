import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(reader.readLine());
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            String str = reader.readLine();

            if (set.contains(str)) {
                cnt++;
            }
        }

        System.out.print(cnt);
    }
}