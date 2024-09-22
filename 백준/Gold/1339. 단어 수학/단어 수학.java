import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        Map<Character, Integer> map = new HashMap<>();
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            String str = reader.readLine();
            arr[i] = str;

            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);

                int turn = str.length() - j - 1;
                map.put(c, map.getOrDefault (c, 0) + (int) Math.pow(10, turn));
            }
        }
        
        List<Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());
        
        int numValue = 9;
        for (Entry<Character, Integer> entry : list) {
            Character key = entry.getKey();
            map.put(key, numValue);
            numValue--;
        }

        int[] resultArr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            StringBuilder builder = new StringBuilder();
            String str = arr[i];
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                Integer num = map.get(c);
                builder.append(num);
            }
            resultArr[i] = Integer.parseInt(builder.toString());
        }

        int answer = 0;
        for (int num : resultArr) {
            answer += num;
        }

        System.out.print(answer);
    }
}