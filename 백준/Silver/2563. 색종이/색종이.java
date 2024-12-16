import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 색종이 갯수

        boolean[][] arr = new boolean[101][101];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);

            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    arr[j][k] = true;
                }
            }
        }
        int cnt = 0;
        for (boolean[] bs : arr) {
            for (boolean b : bs) {
                if (b) {
                    cnt++;
                }
            }
        }

        System.out.print(cnt);
    }
}