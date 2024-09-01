import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(reader.readLine());

        ArrayList<String> inputList = new ArrayList<>();

        for (int i =0; i < num; i++) {
            String input = reader.readLine();
            inputList.add(input);
        }


        // 0: h
        // 1: a
        // 2: p
        // 3: p
        // 4: y
        for (String str : inputList) {
            char beforeChar;
            char nowChar;
            ArrayList<Character> charBlackList = new ArrayList<>();

            for (int i = 1; i < str.length(); i++) {
                beforeChar = str.charAt(i - 1);
                nowChar = str.charAt(i);

                if (charBlackList.contains(nowChar)) {
                    num--;
                    break;
                }

                if (beforeChar != nowChar) {
                    charBlackList.add(beforeChar);
                }
            }
        }

        System.out.println(num);
    }
}