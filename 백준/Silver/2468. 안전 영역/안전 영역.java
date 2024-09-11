import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] region;
    static boolean[][] visited;
    static int N;
    static int MAX_HIGH = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());

        region = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];


        for (int i = 1; i <= N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                region[i][j] = Integer.parseInt(tokenizer.nextToken());
                if (region[i][j] > MAX_HIGH) {
                    MAX_HIGH = region[i][j];
                }
            }
        }

        int cnt = 0;
        int answer = 0;
        for (int i = 0; i < MAX_HIGH; i++) { // 물 높이가 0 부터 1씩 올라간 경우마다 값을 구해 그 중 영역 수 최대를 구해야함
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if (!visited[j][k] && region[j][k] > i){ // 방문을 안했고, 물 높이보다 지역이 더 높으면
                        dfs(j, k, i);
                        cnt++;
                    }
                }
            }
            
            if (cnt > answer) { // 물 높이마다 영역 수 중에서 최대 값을 가지는 것 추출
                answer = cnt;
            }

            visited = new boolean[N + 1][N + 1]; // visited 배열 초기화
            cnt = 0; // 카운트 초기화
        }

        System.out.print(answer);
    }

    static void dfs(int x, int y, int waterHigh) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int moveDx = x + dx[i];
            int moveDy = y + dy[i];

            if (moveDx >= 0 && moveDy >= 0 && moveDx <= N && moveDy <= N) { // 인덱스 경계를 벗어나지 않고
                if (!visited[moveDx][moveDy] && region[moveDx][moveDy] > waterHigh) { // 아직 방문하지 않았고, 현재 물 높이보다 해당 지역의 물 높이가 더 높다면
                    dfs(moveDx, moveDy, waterHigh);
                }
            }
        }
    }
}