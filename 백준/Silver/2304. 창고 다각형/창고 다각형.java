import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int maxHIdx = 0;
    static boolean[][] arr = new boolean[1001][1001];

    static int[][] location;

    static class Node {
        int l;
        int h;

        public Node(int l, int h) {
            this.l = l;
            this.h = h;
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        location = new int[N + 1][2];

        int maxHigh = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());

            location[i + 1][0] = L;
            location[i + 1][1] = H;

            maxHigh = Math.max(maxHigh, H);

            for (int j = 1; j <= H; j++) {
                arr[L][j] = true;
            }
        }

        Arrays.sort(location, Comparator.comparingInt(o -> o[0]));

        for (int i = 1; i <= N; i++) {
            if (location[i][1] == maxHigh) {
                maxHIdx = i;
            }
        }
    }

    static void solve() {
        // 가장 높은 기둥 넓이
        int maxHighWidth = location[maxHIdx][1];

        PriorityQueue<Node> leftPq = new PriorityQueue<>((n1, n2) -> n2.h - n1.h);
        int leftMaxHIdx = maxHIdx - 1;
        while (leftMaxHIdx > 0) {
            int l = location[leftMaxHIdx][0];
            int h = location[leftMaxHIdx][1];

            leftPq.offer(new Node(l, h));
            leftMaxHIdx--;
        }

        // 가장 높은 기둥 기준 왼쪽 넓이를 구한다
        int leftWidth = 0;
        int beforeL = location[maxHIdx][0];
        if (!leftPq.isEmpty()) {
            while (!leftPq.isEmpty()) {
                Node node = leftPq.poll();

                if (node.l < beforeL) {
                    leftWidth += (beforeL - node.l) * node.h;
                    beforeL = node.l;
                }

                if (node.l == location[1][0]) {
                    break;
                }
            }
        }

        // 가장 높은 기둥 기준 오른쪽 넓이를 구한다
        PriorityQueue<Node> rightPq = new PriorityQueue<>((n1, n2) -> n2.h - n1.h);
        int rightMaxHIdx = maxHIdx + 1;
        while (rightMaxHIdx < N + 1) {
            int l = location[rightMaxHIdx][0];
            int h = location[rightMaxHIdx][1];

            rightPq.offer(new Node(l, h));
            rightMaxHIdx++;
        }

        int rightWidth = 0;
        beforeL = location[maxHIdx][0];
        if (!rightPq.isEmpty()) {
            while (!rightPq.isEmpty()) {
                Node node = rightPq.poll();

                if (node.l > beforeL) {
                    rightWidth += (node.l - beforeL) * node.h;
                    beforeL = node.l;
                }

                if (node.l == location[N][0]) {
                    break;
                }
            }
        }

        System.out.print(leftWidth + rightWidth + maxHighWidth);
    }
}