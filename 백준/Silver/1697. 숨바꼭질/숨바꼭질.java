import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    static int[] times = new int[100001]; // 0 ~ 100000 // 인덱스 숫자 = 위치를 나타내고, 해당 위치에는 걸리는 시간 최솟값 저장
    static LinkedList<Integer> q = new LinkedList<>();
    static String[] cmds = new String[] {"-", "+", "*"};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");

        int old = Integer.parseInt(str[0]); // 수빈이의 처음 위치 값
        int young = Integer.parseInt(str[1]); // 동생의 처음 위치 값

        // 최솟값을 넣기 위해 초기값을 크게 설정
        for (int i = 0; i < 100001; i++) {
            times[i] = Integer.MAX_VALUE;
        }

        times[old] = 0;
        q.add(old);
        bfs(old);

        System.out.print(times[young]);
    }

    static void bfs(int old) {
        while (!q.isEmpty()) {
            Integer nowLocation = q.poll();
            int nowTime = times[nowLocation];

            for (String cmd : cmds) {
                int nextLocation;
                if (cmd.equals("-")) {
                    nextLocation = nowLocation - 1;
                } else if (cmd.equals("+")) {
                    nextLocation = nowLocation + 1;
                } else {
                    nextLocation = nowLocation * 2;
                }

                // 0 ~ 100000 범위를 벗어나지 않고, 걸린 시간이 기존보다 더 작은 경우
                if (nextLocation >= 0 && nextLocation <= 100000 && times[nextLocation] > nowTime + 1) {
                    times[nextLocation] = nowTime + 1;
                    q.add(nextLocation);
                }
            }
        }
    }
}