import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(reader.readLine());

        Set<Integer> allSet = IntStream.rangeClosed(1, 20)
            .boxed()
            .collect(Collectors.toCollection(HashSet::new));

        StringBuilder builder = new StringBuilder();

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < num; i++) {
            String input = reader.readLine();

            String[] command = input.split(" ");

            if (command[0].equals("add") && !set.contains(Integer.parseInt(command[1]))) {
                set.add(Integer.parseInt(command[1]));
            }

            if (command[0].equals("remove") && set.contains(Integer.parseInt(command[1]))) {
                set.remove(Integer.parseInt(command[1]));
            }

            if (command[0].equals("check")) {
                builder.append(set.contains(Integer.parseInt(command[1])) ? 1 : 0).append("\n");

            }

            if (command[0].equals("toggle")) {
                if (set.contains(Integer.parseInt(command[1]))) {
                    set.remove(Integer.parseInt(command[1]));
                } else {
                    set.add(Integer.parseInt(command[1]));
                }
            }

            if (command[0].equals("all")) {
                set.clear();
                set.addAll(allSet);
            }

            if (command[0].equals("empty")) {
                set.clear();
            }
        }

        System.out.println(builder.toString());
    }
}