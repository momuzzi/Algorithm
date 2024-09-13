import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        int[][] arr = new int[N + 1][2]; //[1][0] = 걸리는 시간 [1][1] = 금액 [1 ~ N][0 ~ 1]
        //dp[i]에 저장될 값은 i일 상담 시작 전에 모인 최대 금액
        int[] dp = new int[N + 2]; //며칠일때 최대금액 [1 ~ N + 1]

        for (int i = 1; i <= N; i++) {
            String str = reader.readLine();
            String[] strArray = str.split(" ");
            arr[i][0] = Integer.parseInt(strArray[0]);
            arr[i][1] = Integer.parseInt(strArray[1]);
        }


        for (int i = 1; i <= N ; i++) {
            if (i + arr[i][0] - 1 <= N) {
                dp[i + arr[i][0]] = Math.max(dp[i] + arr[i][1], dp[i + arr[i][0]]);
            }

            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }


        System.out.print(dp[N + 1]);
    }
}