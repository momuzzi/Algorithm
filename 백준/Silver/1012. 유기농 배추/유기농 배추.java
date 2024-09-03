import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int garo;
    static int sero;
    static int baechuNum;
    static int[] dx = {0 ,0, -1, 1};
    static int[] dy = {-1, 1 , 0, 0};
    static boolean[][] baechuLocations;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(reader.readLine());

        for (int i = 0; i < num; i++) {
            int white = 0;
            
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            garo = Integer.parseInt(tokenizer.nextToken());
            sero = Integer.parseInt(tokenizer.nextToken());
            baechuNum = Integer.parseInt(tokenizer.nextToken());
            baechuLocations = new boolean[garo][sero];
            isVisited = new boolean[garo][sero];
            
            for (int j = 0; j < baechuNum; j++) {
                String[] baechuLocation= reader.readLine().split(" ");
                baechuLocations[Integer.parseInt(baechuLocation[0])][Integer.parseInt(baechuLocation[1])] = true;
            }

            for (int k = 0; k < garo; k++) {
                for (int l = 0; l < sero; l++) {
                    if (baechuLocations[k][l] && !isVisited[k][l]) {
                        white++;
                        dfs(k, l);
                    }
                }
            }
            System.out.println(white);
        }
    }

    static void dfs(int k, int l) {
        isVisited[k][l] = true;

        for (int i = 0; i < 4; i++) {
            int moveDx = k + dx[i];
            int moveDy = l + dy[i];

            if (moveDx >= 0 && moveDx < garo && moveDy >= 0 && moveDy < sero) {
                if (baechuLocations[moveDx][moveDy] && !isVisited[moveDx][moveDy]) {
                    dfs(moveDx, moveDy);
                }
            }
        }
    }
}