import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int SIZE;
    static int[][] isHouse;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1 , 1, 0, 0};
    static int houseCount;
    static int groupNum = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        SIZE = Integer.parseInt(reader.readLine());

        isHouse = new int[SIZE][SIZE];
        visited = new boolean[SIZE][SIZE];
        List<Integer> houseCountList = new ArrayList<>();
        
        for (int i = 0; i < SIZE; i++) {
            String str = reader.readLine();
            for (int j = 0; j < SIZE; j++) {
                isHouse[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isHouse[i][j] == 1 && !visited[i][j]) {
                    houseCount = 0;
                    groupNum++;
                    dfs(i, j);
                    houseCountList.add(houseCount);
                }
            }
        }

        Collections.sort(houseCountList);
        System.out.println(houseCountList.size());
        for (Integer i : houseCountList) {
            System.out.println(i);
        }
    }

    static void dfs(int i, int j) {
        visited[i][j] = true;
        isHouse[i][j] = groupNum;
        houseCount++;

        for (int k = 0; k < dx.length; k++) {
            int moveDx = i + dx[k];
            int moveDy = j + dy[k];

            if (moveDx >= 0 && moveDx < SIZE && moveDy >= 0 && moveDy < SIZE) {
                if (isHouse[moveDx][moveDy] == 1 && !visited[moveDx][moveDy]) {
                    dfs(moveDx, moveDy);
                }
            }
        }
    }
}