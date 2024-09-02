import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str = reader.readLine();
        String[] input = str.split(" ");

        Integer num = Integer.parseInt(input[0]);
        int money = Integer.parseInt(input[1]);

        Integer[] inputArray = new Integer[num];

        for (int i = 0; i < num; i++) {
            inputArray[i] = Integer.parseInt(reader.readLine());
        }

        Arrays.sort(inputArray, Collections.reverseOrder());

        int cnt = 0;
        for (Integer i : inputArray) {
            while (money >= i) {
                money -= i;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}