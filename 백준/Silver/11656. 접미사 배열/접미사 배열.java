import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();


        String str = reader.readLine();

        List<String> list = new ArrayList<>();
        for (int i = 0 ; i <  str.length(); i++) {
            String subStr = str.substring(i);
            list.add(subStr);
        }

        Collections.sort(list);

        for (String s : list) {
            builder.append(s + "\n");
        }

        System.out.print(builder);

    }
}