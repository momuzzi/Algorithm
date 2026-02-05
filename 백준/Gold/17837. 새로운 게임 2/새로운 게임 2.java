import java.io.*;
import java.util.*;

public class Main {

    static class Horse {
        int num;
        int x;
        int y;
        int d;

        Horse(int num, int x, int y, int d) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    static int[][] graph;
    static ArrayDeque<Horse>[][] horseGraph;
    static Map<Integer, Horse> map = new HashMap<>();
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};
    static boolean isFull = false;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");
        N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);

        graph = new int[N + 1][N + 1];
        horseGraph = new ArrayDeque[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                horseGraph[i][j] = new ArrayDeque<>();
            }
        }

        for (int i = 1; i <= K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            Horse horse = new Horse(i, x, y, d);
            map.put(i, horse);
            horseGraph[x][y].push(horse);
        }

        int time = 1;
        while (time < 1001) {
            for (int i = 1; i <= K; i++) {
                Horse horse = map.get(i);
                int nowD = horse.d;

                int nextX = horse.x + dx[nowD];
                int nextY = horse.y + dy[nowD];

                if (nextX < 1 || nextX > N || nextY < 1 || nextY > N || graph[nextX][nextY] == 2) {
                    nowD = getReverseD(nowD);
                    nextX = horse.x + dx[nowD];
                    nextY = horse.y + dy[nowD];
                    horse.d = nowD;

                    if (nextX < 1 || nextX > N || nextY < 1 || nextY > N) continue;
                }

                int color = graph[nextX][nextY];

                if (color == 0) {
                    goWhite(horse, nextX, nextY);
                } else if (color == 1) {
                    goRed(horse, nextX, nextY);
                }

                if (isFull) {
                    System.out.print(time);
                    return;
                }
            }

            time++;
        }

        System.out.print(-1);
    }

    static void goWhite(Horse horse, int nextX, int nextY) {
        ArrayDeque<Horse> newLocStack = new ArrayDeque<>();

        while (true) {
            Horse pop = horseGraph[horse.x][horse.y].pop();
            pop.x = nextX;
            pop.y = nextY;
            newLocStack.push(pop);

            if (pop.num == horse.num) break;
        }


        while (!newLocStack.isEmpty()) {
            horseGraph[nextX][nextY].push(newLocStack.pop());
        }

        if (horseGraph[nextX][nextY].size() >= 4) isFull = true;
    }

    static void goRed(Horse horse, int nextX, int nextY) {
        ArrayDeque<Horse> newLocStack = new ArrayDeque<>();

        while (true) {
            Horse pop = horseGraph[horse.x][horse.y].pop();
            pop.x = nextX;
            pop.y = nextY;
            newLocStack.offer(pop);

            if (pop.num == horse.num) break;
        }

        while (!newLocStack.isEmpty()) {
            horseGraph[nextX][nextY].push(newLocStack.pollFirst());
        }

        if (horseGraph[nextX][nextY].size() >= 4) isFull = true;
    }

    static int getReverseD(int d) {
        if (d == 1) return 2;
        if (d == 2) return 1;
        if (d == 3) return 4;
        return 3;
    }
}