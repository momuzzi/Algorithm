import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(reader.readLine());

        int answer = 0;
        while (num > 0) {
            if (num % 5 == 0) {
                answer += num / 5;
                break;
            }

            num -= 3;
            answer++;

            if (num < 0) {
                answer = -1;
            }
        }
        System.out.print(answer);
    }
}