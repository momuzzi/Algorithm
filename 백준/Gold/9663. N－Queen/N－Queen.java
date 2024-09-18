import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int cnt;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[0] = i; //(0, i)에 퀸을 놓았다는 의미
            bt(1); //0번째 줄은 이미 놓음, 1번째 줄부터 퀸을 하나씩 놓기 시도
        }

        System.out.print(cnt);
    }

    static void bt(int garo) {
        if (garo == N) {
            cnt++; //퀸을 전부 놓았으므로 경우의 수 1 증가
            return;
        }

        for (int sero = 0; sero < N; sero++) {
            if (safe(garo, sero)) {
                arr[garo] = sero;
                bt(garo + 1);
            }
        }
    }

    // (garo, sero) = (x, y)
    static boolean safe(int x, int y) {
        for (int i = 0; i < x; i++) {
            // 같은 열에 위치한 퀸이 있는지 체크
            if (arr[i] == y) {
                return false;
            }
            // 대각선 체크
            if (Math.abs(x - i) == Math.abs(y - arr[i])) {
                return false;
            }
        }

        return true;
    }
}