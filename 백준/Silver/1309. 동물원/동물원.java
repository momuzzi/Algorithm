import java.io.*;

public class Main {

    static int MOD = 9901;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][3];

        arr[0][0] = 1; // 1번째줄 왼쪽에 놓는 경우
        arr[0][1] = 1; // 1번째줄 오른쪽에 놓는 경우
        arr[0][2] = 1; // 1번째줄에 안 놓는 경우

        for (int i = 1; i < N; i++) {
            arr[i][0] = arr[i - 1][1] + arr[i - 1][2] % MOD;
            arr[i][1] = arr[i - 1][0] + arr[i - 1][2] % MOD;
            arr[i][2] = arr[i - 1][0] + arr[i - 1][1] + arr[i - 1][2] % MOD;
        }

        System.out.print((arr[N - 1][0] + arr[N - 1][1] + arr[N - 1][2]) % MOD);
    }
}