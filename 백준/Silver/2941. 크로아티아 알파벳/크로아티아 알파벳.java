import java.io.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        List<String> list = List.of("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=");

        String input = reader.readLine();

        int cnt = 0;

        // lj, e, s=, nj, a, k
        // ddz=z= -> d z=
        for(String word : list) {
            int inputLength = input.replace(" ", "").length();

            input = input.replace(word, " ");

            int afterInputLength = input.replace(" ", "").length();

            if (inputLength != afterInputLength) {
                int how = inputLength - afterInputLength;

                cnt += how / word.length();
            }
        }

        if (input.replace(" ", "").length() > 0) {
            cnt += input.replace(" ", "").length();
        }

        builder.append(cnt);
        System.out.print(builder);
    }
}