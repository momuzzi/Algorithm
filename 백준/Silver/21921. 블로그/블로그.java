import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nx = br.readLine().split(" ");

        int N = Integer.parseInt(nx[0]);
        int X = Integer.parseInt(nx[1]);
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        int answer = 0;
        int cnt = 1;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            if (i < X) {
                sum += num;
                answer = sum;
                continue;
            }

            sum += num;
            sum -= arr[i - X];

            if (sum == answer) {
                cnt++;
            }

            if (sum > answer) {
                answer = sum;
                cnt = 1;
            }
        }

        if (answer == 0) {
            System.out.print("SAD");
        } else {
            System.out.println(answer);
            System.out.print(cnt);
        }
    }
}