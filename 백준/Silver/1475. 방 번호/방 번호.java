import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String N = reader.readLine();

        // 0~8 (9는 6에다가 카운트)
        int[] cnt = new int[9];

        for (int i = 0; i < N.length(); i++) {
            int index = N.charAt(i) - '0';

            if (index == 9) {
                index = 6;
            }

            cnt[index]++;
        }

        cnt[6] = (cnt[6] + 1) / 2;

        int max = 0;
        for (int num : cnt) {
            max = Math.max(max, num);
        }
        
        System.out.print(max);
    }
}