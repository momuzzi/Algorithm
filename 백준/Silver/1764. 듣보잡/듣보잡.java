import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        String[] input = reader.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String name = reader.readLine();
            set.add(name);
        }

        for (int i = 0; i < M; i++) {
            String name = reader.readLine();
            if (set.contains(name)) {
                list.add(name);
            }
        }

        Collections.sort(list);

        builder.append(list.size() + "\n");

        for (String s : list) {
            builder.append(s + "\n");
        }

        System.out.print(builder);
    }
}