import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        int[][] timePair = new int[N][2]; // [0] 시작 시각, [1] 종료 시각

        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            int startTime = Integer.parseInt(tokenizer.nextToken());
            int endTime = Integer.parseInt(tokenizer.nextToken());

            timePair[i][0] = startTime;
            timePair[i][1] = endTime;
        }

        // 시작 시간 기준 오름차순, 시작 시간이 같다면 종료 시간 기준 오름차순
        Arrays.sort(timePair, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 시작 시간이 같다면
                if (o1[0] == o2[0]) {
                    return Integer.compare(o1[1], o2[1]);
                } else { // 시작 시간이 다르면
                    return Integer.compare(o1[0], o2[0]);
                }
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(timePair[0][1]);
        int roomCnt = 1;

        for (int i = 1; i < N; i++) {
            // 우선 순위 큐에 들어 있는 사용 강의실에서 종료시간이 가장 빠른 것을 꺼냈을 때, 현재 인덱스의 강의의 시작 시간이 종료시간 보다 더 빠르면 큐에서 해당 원소를 빼고 현재 인덱스의 종료시간을 pq에 add한다. (강의실 재사용, 해당 강의실 종료시간 업데이트)
            if (timePair[i][0] >= pq.peek()) {
                pq.poll();
                pq.add(timePair[i][1]);
            } else { // 재사용할 수 있는 강의실이 없기 때문에, 새로운 강의실 배정
                pq.add(timePair[i][1]);
                roomCnt++;
            }
        }

        System.out.print(roomCnt);
    }
}