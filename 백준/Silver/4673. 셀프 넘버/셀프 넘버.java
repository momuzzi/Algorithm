import java.io.IOException;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {

        HashSet<Integer> intSet = new HashSet<>();

        for (int i = 1; i <= 10000; i++) {
            String str = String.valueOf(i);

            int value = i;
            for (int j = 0; j < str.length(); j++) {
                value += Integer.parseInt(String.valueOf(str.charAt(j)));

            }
            intSet.add(value);
        }

        for (int i = 1; i <= 10000; i++) {
            if (!intSet.contains(i)) {
                System.out.println(i);
            }
        }
    }
}