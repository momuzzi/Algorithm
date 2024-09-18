import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
    static int[][] times = new int[100001][2]; // 0 ~ 100000 // 인덱스 숫자 = 위치를 나타내고, [0] 해당 위치에는 걸리는 시간 최솟값 저장,,, [1] 직전 위치 값 저장
    static LinkedList<Integer> q = new LinkedList<>();
    static String[] cmds = new String[] {"-", "+", "*"};
    static int young;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");

        int old = Integer.parseInt(str[0]); // 수빈이의 처음 위치 값
        young = Integer.parseInt(str[1]); // 동생의 처음 위치 값

        // 최솟값을 넣기 위해 초기값을 크게 설정
        for (int i = 0; i < 100001; i++) {
            times[i][0] = Integer.MAX_VALUE;
        }

        times[old][0] = 0;
        times[old][1] = -1;
        q.add(old);
        bfs();
        
        StringBuilder builder = new StringBuilder();
        builder.append(times[young][0]).append("\n");

        Stack<Integer> stack = new Stack<>();

        int location = young;
        while (location != -1) {
            stack.push(location);
            location = times[location][1];
        }

        while (!stack.isEmpty()) {
            builder.append(stack.pop()).append(" ");
        }

        System.out.print(builder);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            Integer nowLocation = q.poll();

            int nowTime = times[nowLocation][0];

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
                if (nextLocation >= 0 && nextLocation <= 100000 && times[nextLocation][0] >= nowTime + 1) {
                    times[nextLocation][0] = nowTime + 1;
                    times[nextLocation][1] = nowLocation;
                    q.add(nextLocation);
                }
            }
        }
    }
}