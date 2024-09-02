import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static final int SIZE = 101;
    static boolean[][] networkLine;
    static boolean[] heated;
    static int computerNum;
    static int computerNumInNetwork;
    static LinkedList<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        computerNum = Integer.parseInt(reader.readLine());
        computerNumInNetwork = Integer.parseInt(reader.readLine());

        networkLine = new boolean[SIZE][SIZE];
        heated = new boolean[SIZE];

        for (int i = 0; i < computerNumInNetwork; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());

            networkLine[x][y] = networkLine[y][x] = true;
        }

        System.out.print(bfs());
    }

    static int bfs() {
        q = new LinkedList<>();
        heated[1] = true;
        q.add(1);
        int cnt = 0;
        while (!q.isEmpty()) {
            int idx = q.poll();
            for (int i = 1; i <= computerNum; i++) {
                if (!heated[i] && networkLine[idx][i]) {
                    heated[i] = true;
                    q.add(i);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}