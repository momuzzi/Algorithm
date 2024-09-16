import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String str = reader.readLine();
            if (!list.contains(str)) {
                list.add(str);
            }
        }

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }

                return o1.length() - o2.length();
            }
        });

        for (String str : list) {
            System.out.println(str);
        }
    }
}