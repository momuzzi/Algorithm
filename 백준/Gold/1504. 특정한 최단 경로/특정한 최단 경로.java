import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int E;

    static List<Node>[] graph;
    static int[] lengthArr;

    static int V1;
    static int V2;

    static class Node {

        int toV;
        int length;

        public Node(int toV, int length) {
            this.toV = toV;
            this.length = length;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        E = Integer.parseInt(s[1]);

        graph = new ArrayList[N + 1];
        lengthArr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startV = Integer.parseInt(st.nextToken());
            int endV = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            graph[startV].add(new Node(endV, length));
            graph[endV].add(new Node(startV, length));
        }

        String[] ss = br.readLine().split(" ");
        V1 = Integer.parseInt(ss[0]);
        V2 = Integer.parseInt(ss[1]);

        int pathA1 = dijk(1, V1);
        int pathA2 = dijk(V1, V2);
        int pathA3 = dijk(V2, N);

        int pathA = pathA1 + pathA2 + pathA3;

        if (pathA1 == -1 || pathA2 == -1 || pathA3 == -1) {
            pathA = -1;
        }

        int pathB1 = dijk(1, V2);
        int pathB2 = dijk(V2, V1);
        int pathB3 = dijk(V1, N);

        int pathB = pathB1 + pathB2 + pathB3;

        if (pathB1 == -1 || pathB2 == -1 || pathB3 == -1) {
            pathB = -1;
        }

        if (pathA == -1 || pathB == -1) {
            System.out.print(pathA != -1 ? pathA : pathB);
            return;
        }

        System.out.print(Math.min(pathA, pathB));
    }

    static int dijk(int start, int end) {
        Arrays.fill(lengthArr, Integer.MAX_VALUE);
        lengthArr[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.length - n2.length);

        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (node.toV == end) {
                return lengthArr[end];
            }

            if (lengthArr[node.toV] < node.length) continue;

            for (Node nextNode : graph[node.toV]) {
                if (lengthArr[nextNode.toV] > node.length + nextNode.length) {
                    lengthArr[nextNode.toV] = node.length + nextNode.length;

                    pq.offer(new Node(nextNode.toV, lengthArr[nextNode.toV]));
                }
            }
        }

        return -1;
    }
}