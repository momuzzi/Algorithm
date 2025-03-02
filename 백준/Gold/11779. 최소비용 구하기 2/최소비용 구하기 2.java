import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;

    static int n;
    static int m;

    static List<City>[] graph;
    static int[][] moneyAndBeforeCity;

    static class City {
        int num;
        int money;

        public City(int num, int money) {
            this.num = num;
            this.money = money;
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        moneyAndBeforeCity = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            moneyAndBeforeCity[i][0] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int fromCity = Integer.parseInt(st.nextToken());
            int toCity = Integer.parseInt(st.nextToken());
            int busMoney = Integer.parseInt(st.nextToken());

            graph[fromCity].add(new City(toCity, busMoney));
        }
    }

    static void solve() throws Exception {
        String[] s = br.readLine().split(" ");
        int start = Integer.parseInt(s[0]);
        int end = Integer.parseInt(s[1]);

        dijk(start, end);

        StringBuilder sb = new StringBuilder();

        sb.append(moneyAndBeforeCity[end][0] + "\n");

        int cityNum = moneyAndBeforeCity[end][1];
        int cnt = 2;
        Stack<Integer> stack = new Stack<>();
        stack.push(end);
        while (cityNum != start) {
            stack.push(cityNum);
            cityNum = moneyAndBeforeCity[cityNum][1];

            cnt++;
        }

        stack.push(start);

        sb.append(cnt + "\n");

        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        System.out.print(sb);
    }

    static void dijk(int start, int end) {
        PriorityQueue<City> pq = new PriorityQueue<>((c1, c2) -> c1.money - c2.money);

        moneyAndBeforeCity[start][0] = 0;

        pq.offer(new City(start, 0));

        while (!pq.isEmpty()) {
            City city = pq.poll();

            if (city.num == end) {
                return;
            }

            for (City nextCity : graph[city.num]) {
                if (moneyAndBeforeCity[nextCity.num][0] > city.money + nextCity.money) {
                    moneyAndBeforeCity[nextCity.num][0] = city.money + nextCity.money;
                    moneyAndBeforeCity[nextCity.num][1] = city.num;

                    pq.offer(new City(nextCity.num, moneyAndBeforeCity[nextCity.num][0]));
                }
            }
        }
    }
}