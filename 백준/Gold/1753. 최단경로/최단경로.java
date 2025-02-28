import java.util.*;
import java.io.*;

public class Main {

    static int V;
    static int E;
    static List<Node>[] graph; // 인덱스 : 출발 노드, 해당 배열 인덱스 안의 리스트 안의 노드 : 출발 정점에서 갈 수 있는 노드
    static int[] dist;
    static int start;

    static class Node {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        V = Integer.parseInt(s[0]);
        E = Integer.parseInt(s[1]);

        graph = new ArrayList[V + 1];

        dist = new int[V + 1]; // 해당 정점으로의 최소 거리 저장할 배열

        start = Integer.parseInt(br.readLine());

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
        }

        dijk(start);

        for (int i = 1; i <= V; i++) {
            System.out.println(dist[i] != Integer.MAX_VALUE ? dist[i] : "INF");
        }
    }

    static void dijk(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.w - n2.w);

        dist[start] = 0; // 시작점이므로 거리는 0으로 초기화
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            for (Node nextNode : graph[node.v]) {
                if (dist[nextNode.v] > node.w + nextNode.w) {
                    dist[nextNode.v] = node.w + nextNode.w;
                    pq.add(new Node(nextNode.v, dist[nextNode.v]));
                }
            }
        }
    }
}