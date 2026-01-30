import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        if (s.length() == 1) {
            System.out.print(1);
            return;
        }

        if (N == 1) {
            int max = 1;
            int cnt = 1;
            char beforeC = '.';
            for (int i = 0; i < s.length(); i++) {
                if (beforeC == s.charAt(i)) {
                    cnt++;
                    max = Math.max(max, cnt);
                } else {
                    cnt = 1;
                }

                beforeC = s.charAt(i);
            }

            System.out.print(max);

            return;
        }

        Map<Character, Integer> map = new HashMap<>();

        if (s.charAt(0) == s.charAt(1)) {
            map.put(s.charAt(0), 2);
        } else {
            map.put(s.charAt(0), 1);
            map.put(s.charAt(1), 1);
        }

        int ans = 2;
        int left = 0;
        int right = 1;
        while (right < s.length()) {
            right++;

            if (right == s.length()) break;

            char rc = s.charAt(right);

            if (!map.containsKey(rc)) {
                if (map.size() < N) {
                    map.put(rc, 1);
                } else if (map.size() == N) {
                    while (true) {
                        char lc = s.charAt(left);
                        if (map.get(lc) > 1) {
                            map.put(lc, map.get(lc) - 1);
                            left++;
                        } else {
                            map.remove(lc);
                            left++;
                            break;
                        }
                    }

                    map.put(rc, 1);
                }
            } else {
                map.put(rc, map.get(rc) + 1);
            }

            ans = Math.max(ans, right - left + 1);
        }

        System.out.print(ans);
    }
}