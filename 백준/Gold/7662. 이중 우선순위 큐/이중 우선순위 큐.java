import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> minQ = new PriorityQueue<>();
            PriorityQueue<Integer> maxQ = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

            Map<Integer, Integer> map = new HashMap<>();

            for (int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                String c = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                if (c.equals("I")) {
                    minQ.offer(n);
                    maxQ.offer(n);
                    map.put(n, map.getOrDefault(n, 0) + 1);
                } else {
                    if (n == 1) {
                        while (!maxQ.isEmpty()) {
                            int poll = maxQ.poll();

                            if (map.get(poll) > 0) {
                                map.put(poll, map.get(poll) - 1);
                                break;
                            }
                        }
                    } else {
                        while (!minQ.isEmpty()) {
                            int poll = minQ.poll();

                            if (map.get(poll) > 0) {
                                map.put(poll, map.get(poll) - 1);
                                break;
                            }
                        }
                    }
                }
            }

            while (!minQ.isEmpty() && map.get(minQ.peek()) == 0) {
                minQ.poll();
            }

            while (!maxQ.isEmpty() && map.get(maxQ.peek()) == 0) {
                maxQ.poll();
            }

            sb.append(minQ.isEmpty() ? "EMPTY" + "\n" : maxQ.peek() + " " + minQ.peek() + "\n");
        }

        System.out.print(sb);
    }
}