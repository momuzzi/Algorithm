import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int num;
        int first;
        int cnt;

        Node(int n, int f, int c) {
            num = n;
            first = f;
            cnt = c;
        }

        void increase() {
            cnt++;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NC = br.readLine().split(" ");
        int N = Integer.parseInt(NC[0]);
        int C = Integer.parseInt(NC[1]);

        Set<Integer> set = new HashSet<>();
        Map<Integer, Node> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());

            if (set.contains(n)) {
                Node node = map.get(n);
                node.increase();
            } else {
                set.add(n);
                map.put(n, new Node(n, i, 1));
            }
        }

        List<Node> list = new ArrayList<>();

        Set<Integer> keySet = map.keySet();
        for (int key : keySet) {
            Node node = map.get(key);
            list.add(node);
        }

        list.sort((a, b) -> {
            if (a.cnt == b.cnt) {
                return a.first - b.first;
            }

            return b.cnt - a.cnt;
        });

        StringBuilder sb = new StringBuilder();
        for (Node node : list) {
            for (int i = 0; i < node.cnt; i++) {
                sb.append(node.num + " ");
            }
        }

        System.out.print(sb);
    }
}