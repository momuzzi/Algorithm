import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int sero;
    static int garo;
    static int[][] miroLocations;
    static boolean[][] isVisited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1 ,0, 0};
    static LinkedList<int[]> q;
    static int[][] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        sero = Integer.parseInt(tokenizer.nextToken()); // 4
        garo = Integer.parseInt(tokenizer.nextToken()); // 6
        miroLocations = new int[sero][garo];
        isVisited = new boolean[sero][garo];
        distance = new int[sero][garo];
        for (int j = 0; j < sero; j++) {
            String str = reader.readLine();
            for (int k = 0; k < str.length(); k++) {
                int validBlock = Character.getNumericValue(str.charAt(k)); // 0 or 1
                miroLocations[j][k] = validBlock;
            }
        }

        bfs(0, 0);

        System.out.print(distance[sero - 1][garo - 1]);
    }

    static void bfs(int l, int m) {
        q = new LinkedList<>();
        isVisited[l][m] = true;
        q.add(new int[] {l, m});
        distance[l][m] = 1;
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];

            for (int i = 0; i < 4; i++) {
                int moveDx = x + dx[i];
                int moveDy = y + dy[i];

                if (moveDx < 0 || moveDy < 0 || moveDx >= sero || moveDy >= garo) {
                    continue;
                }

                if (miroLocations[moveDx][moveDy] == 0 || isVisited[moveDx][moveDy]) {
                    continue;
                }

                isVisited[moveDx][moveDy] = true;
                q.add(new int[] {moveDx, moveDy});
                distance[moveDx][moveDy] = distance[x][y] + 1;
            }
        }
    }
}