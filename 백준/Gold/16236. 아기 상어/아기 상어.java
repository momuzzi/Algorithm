import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] graph;
    static int sx, sy;
    static int sharkLevel = 2;
    static int eatFishCnt = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node {
        int x;
        int y;
        int t;

        Node(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        sx = 0;
        sy = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                graph[i][j] = n;
                
                if (n == 9) {
                    sx = i;
                    sy = j;
                }
            }
        }

        int time = 0;
        while (true) {
            List<Node> result = goToFish(sx, sy);

            if (result.size() == 0) break;

            int minTime = Integer.MAX_VALUE;
            int x = 0;
            int y = 0;
            for (Node node : result) {
                if (node.t < minTime) {
                    x = node.x;
                    y = node.y;
                    minTime = node.t;
                } else if (node.t == minTime) {
                    if (node.x < x) {
                        x = node.x;
                        y = node.y;
                    } else if (node.x == x && node.y < y) {
                        y = node.y;
                    }
                }
            }

            graph[sx][sy] = 0;
            graph[x][y] = 0;
            
            sx = x;
            sy = y;

            eatFishCnt++;
            levelUp();

            time += minTime;
        }

        System.out.print(time);
    }

    static List<Node> goToFish(int a, int b) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(a, b, 0));
        boolean[][] visit = new boolean[N][N];
        
        List<Node> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        
        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int x = node.x + dx[i];
                int y = node.y + dy[i];

                if (x < 0 || x >= N || y < 0 || y >= N) continue;

                if (visit[x][y]) continue;

                if (graph[x][y] != 0 && graph[x][y] < sharkLevel) {
                    Node nextNode = new Node(x, y, node.t + 1);

                    if (min > nextNode.t) {
                        min = nextNode.t;
                        list = new ArrayList<>();
                        list.add(nextNode);
                    } else if (min == nextNode.t) {
                        list.add(nextNode);
                    }
                    
                    visit[x][y] = true;
                    q.offer(nextNode);

                } else if (graph[x][y] == sharkLevel || graph[x][y] == 0) {
                    q.offer(new Node(x, y, node.t + 1));
                    visit[x][y] = true;
                }
            }
        }

        return list;
    }

    static void levelUp() {
        if (sharkLevel == eatFishCnt) {
            sharkLevel++;
            eatFishCnt = 0;
        }
    }
}