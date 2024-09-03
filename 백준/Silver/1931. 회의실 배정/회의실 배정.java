import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(reader.readLine());

        int[][] timePair = new int[num][2];

        for (int i = 0; i < num; i++) {
            String[] s = reader.readLine().split(" ");
            timePair[i][0] = Integer.parseInt(s[0]);
            timePair[i][1] = Integer.parseInt(s[1]);
        }

        Arrays.sort(timePair, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return Integer.compare(o1[0], o2[0]);
                } else {
                    return Integer.compare(o1[1], o2[1]);
                }
            }
        });

        int answer = 1;
        int nowRoomIndex = 0;
        for (int i = 1; i < num; i++) {
            if (timePair[i][0] >= timePair[nowRoomIndex][1]) {
                nowRoomIndex = i;
                answer++;
            }
        }

        System.out.print(answer);
    }
}