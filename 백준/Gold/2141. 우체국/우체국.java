import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long sum = 0;
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] XA = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(XA[0]);
            arr[i][1] = Integer.parseInt(XA[1]);

            sum += arr[i][1];
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        
        long people = 0;
        for (int i = 0; i < N; i++) {
            if ((people + arr[i][1]) * 2 >= sum) {
                System.out.print(arr[i][0]);
                return;
            }

            people += arr[i][1];
        }
    }
}