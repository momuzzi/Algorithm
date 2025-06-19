import java.io.*;
import java.util.*;

public class Main {

    static Map<Character, Integer> map = new HashMap<>();;
    static Character oddNumChar = null;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                int cnt = map.get(c);
                map.put(c, cnt + 1);
            } else {
                map.put(c, 1);
            }
        }
    }

    static void solve() {
        if (!oddNumIsOne()) {
            System.out.print("I'm Sorry Hansoo");
            return;
        }

        List<Character> charList = new ArrayList<>(map.keySet());
        Collections.sort(charList);
        StringBuilder sb = new StringBuilder();

        for (Character c : charList) {
            int cnt = map.get(c);
            for (int i = 0; i < cnt / 2; i++) {
                sb.append(c);
            }
        }

        String left = sb.toString();
        String right = sb.reverse().toString();

        if (oddNumChar != null) {
            left += oddNumChar.toString();
        }
        
        System.out.print(left + right);
    }

    static boolean oddNumIsOne() {
        Set<Character> keySet = map.keySet();

        int oddCnt = 0;
        for (Character c : keySet) {
            int cnt = map.get(c);

            if (cnt % 2 != 0) {
                oddCnt++;
                oddNumChar = c;
            }
        }

        return oddCnt <= 1;
    }
}