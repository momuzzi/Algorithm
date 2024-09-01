import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(reader.readLine());

        ArrayList<Integer> inputList = new ArrayList<>();

        for (int i =0; i < num; i++) {
            int input = Integer.parseInt(reader.readLine());
            inputList.add(input);
        }

        Collections.sort(inputList);

        for (int i : inputList) {
            System.out.println(i);
        }
    }
}