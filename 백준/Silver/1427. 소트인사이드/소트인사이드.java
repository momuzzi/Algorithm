import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();

        int[] arr = new int[s.length()];

        String[] split = s.split("");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(arr);

        StringBuilder builder = new StringBuilder();

        for (int i = arr.length - 1; i >= 0; i--) {
            builder.append(arr[i]);
        }

        System.out.print(builder);
    }
}