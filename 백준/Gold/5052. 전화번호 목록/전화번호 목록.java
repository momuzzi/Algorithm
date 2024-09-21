import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            String[] arr = new String[n];
            for (int j = 0; j < n; j++) {
                arr[j] = reader.readLine();
            }

            Arrays.sort(arr);

            HashSet<String> set = new HashSet<>();
            boolean flag = false;
            for (int k = 0; k < n; k++) {
                int index = 1;
                String str = arr[k];
                flag = false;

                // 해당 인덱스번째의 번호를 하나씩 자르면서 접두사로 사용된 번호가 있는지 확인한다.
                while (index != str.length() + 1) {
                    if (set.contains(str.substring(0, index))) {
                        builder.append("NO").append("\n");
                        flag = true;
                        break;
                    }

                    index++;
                }

                if (!flag) {
                    set.add(str);
                } else {
                    break;
                }
            }

            if (!flag) {
                builder.append("YES").append("\n");
            }

        }

        System.out.print(builder);
    }
}