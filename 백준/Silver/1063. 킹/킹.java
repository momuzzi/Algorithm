import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {0, 0, -1, 1, 1, 1, -1, -1};
    static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
    static int kx, ky;
    static int sx, sy;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] KSN = br.readLine().split(" ");
        String K = KSN[0];
        String S = KSN[1];
        int N = Integer.parseInt(KSN[2]);

        ky = K.charAt(0) - 'A' + 1;
        kx = K.charAt(1) - '0';

        sy = S.charAt(0) - 'A' + 1;
        sx = S.charAt(1) - '0';

        for (int i = 0; i < N; i++) {
            String cmd = br.readLine();
            move(getIdx(cmd));
        }

        char c = 'A';
        c -= 1;

        StringBuilder sb = new StringBuilder();
        sb.append((char) (c + ky)).append(kx + "\n");
        sb.append((char) (c + sy)).append(sx);
        System.out.print(sb);
    }

    static void move(int i) {
        int kX = kx + dx[i];
        int kY = ky + dy[i];

        if (kX < 1 || kX > 8 || kY < 1 || kY > 8) return;

        if (kX == sx && kY == sy) {
            int sX = sx + dx[i];
            int sY = sy + dy[i];

            if (sX < 1 || sX > 8 || sY < 1 || sY > 8) return;
            
            sx = sX;
            sy = sY;
        }

        kx = kX;
        ky = kY;
    }

    static int getIdx(String s) {
        if (s.equals("R")) {
            return 0;
        } else if (s.equals("L")) {
            return 1;
        } else if (s.equals("B")) {
            return 2;
        } else if (s.equals("T")) {
            return 3;
        } else if (s.equals("RT")) {
            return 4;
        } else if (s.equals("LT")) {
            return 5;
        } else if (s.equals("RB")) {
            return 6;
        } else {
            return 7;
        }
    }
}
