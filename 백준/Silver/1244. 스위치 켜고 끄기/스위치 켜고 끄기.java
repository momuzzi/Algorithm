import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        int switchCnt = Integer.parseInt(reader.readLine());

        int[] switchState = new int[switchCnt + 1];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        for (int i = 1; i <= switchCnt; i++) {
            switchState[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int studentNum = Integer.parseInt(reader.readLine());

        for (int i = 0; i < studentNum; i++) {
            String input = reader.readLine();
            String[] arr = input.split(" ");

            int gender = Integer.parseInt(arr[0]);
            int num = Integer.parseInt(arr[1]);

            // 남학생인 경우
            if (gender == 1) {
                for (int j = num; j <= switchCnt; j += num) {
                    switchState[j] = 1 - switchState[j];
                }
            }

            // 여학생인 경우
            if (gender == 2) {
                int how = 0;
                while (num - how > 0 && num + how <= switchCnt && (switchState[num - how] == switchState[num + how])) {
                    how++;
                }

                how--;

                for (int j = num - how; j <= num + how; j++) {
                    switchState[j] = 1 - switchState[j];
                }
            }
        }

        for (int i = 1; i <= switchCnt; i++) {
            builder.append(switchState[i]).append(" ");
            
            if (i % 20 == 0) {
                builder.append("\n");
            }
        }

        System.out.print(builder);
    }
}