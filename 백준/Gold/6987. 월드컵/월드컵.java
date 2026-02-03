import java.io.*;
import java.util.*;

public class Main {

    static int[][] team;
    static List<int[]> list = new ArrayList<>();
    static boolean[] visit = new boolean[6];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        makeGame(0, new ArrayList<>());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            team = new int[6][3];

            boolean can = true;
            for (int j = 0; j < 6; j++) {
                int s = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());

                team[j][0] = s;
                team[j][1] = m;
                team[j][2] = p;

                if (s + m + p != 5) {
                    can = false;
                    sb.append(0 + " ");
                    break;
                }
            }

            if (can) sb.append(bt(0) ? 1 : 0).append(" ");
        }

        System.out.print(sb);
    }

    static void makeGame(int depth, List<Integer> game) {
        if (depth == 2) {
            list.add(new int[] {game.get(0), game.get(1)});
            return;
        }

        for (int i = game.isEmpty() ? 0 : game.get(0); i < 6; i++) {
            if (!visit[i]) {
                visit[i] = true;
                game.add(i);
                makeGame(depth + 1, game);
                game.remove(game.size() - 1);
                visit[i] = false;
            }
        }
    }

    static boolean bt(int depth) {
        if (depth == 15) {
            return true;
        }

        int[] ab = list.get(depth);
        int a = ab[0];
        int b = ab[1];

        if (team[a][0] > 0 && team[b][2] > 0) {
            team[a][0] -= 1;
            team[b][2] -= 1;
            if (bt(depth + 1)) return true;
            team[a][0] += 1;
            team[b][2] += 1;
        }

        if (team[a][1] > 0 && team[b][1] > 0) {
            team[a][1] -= 1;
            team[b][1] -= 1;
            if (bt(depth + 1)) return true;
            team[a][1] += 1;
            team[b][1] += 1;
        }

        if (team[a][2] > 0 && team[b][0] > 0) {
            team[a][2] -= 1;
            team[b][0] -= 1;
            if (bt(depth + 1)) return true;
            team[a][2] += 1;
            team[b][0] += 1;
        }

        return false;
    }

}