import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        char[] inputArr = input.toCharArray();

        String bomb = br.readLine();
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < inputArr.length; i++) {
            s.push(inputArr[i]);

            if (s.size() >= bomb.length()) {
                boolean flag = true;
                for (int j = 0; j < bomb.length(); j++) {
                    if (!s.get(s.size() - bomb.length() + j).equals(bomb.charAt(j))) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    for (int k = 0; k < bomb.length(); k++) {
                        s.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (s.isEmpty()) {
            sb.append("FRULA");
        } else {
            for (int i = 0; i < s.size(); i++) {
                sb.append(s.get(i));
            }
        }

        System.out.println(sb);
    }
}