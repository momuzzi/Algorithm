import java.util.*;
import java.io.*;

public class Main {

    static int cityCnt;
    static int busCnt;

    static List<City>[] graph;
    static int[] feeArr;

    static int start;
    static int end;

    static class City {
        int arriveCityNum;
        int busFee;

        public City(int arriveCityNum, int busFee) {
            this.arriveCityNum = arriveCityNum;
            this.busFee = busFee;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        cityCnt = Integer.parseInt(br.readLine());
        busCnt = Integer.parseInt(br.readLine());

        graph = new ArrayList[cityCnt + 1];
        feeArr = new int[cityCnt + 1];

        for (int i = 1; i <= cityCnt; i++) {
            feeArr[i] = Integer.MAX_VALUE;
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < busCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startCity = Integer.parseInt(st.nextToken());
            int endCity = Integer.parseInt(st.nextToken());
            int busFee = Integer.parseInt(st.nextToken());

            graph[startCity].add(new City(endCity, busFee));
        }

        String[] s = br.readLine().split(" ");
        start = Integer.parseInt(s[0]);
        end = Integer.parseInt(s[1]);

        dijk(start);

        System.out.print(feeArr[end]);
    }

    static void dijk(int start) {
        PriorityQueue<City> pq = new PriorityQueue<>((c1, c2) -> c1.busFee - c2.busFee);

        feeArr[start] = 0;

        pq.offer(new City(start, 0));

        while (!pq.isEmpty()) {
            City city = pq.poll();

            if (city.arriveCityNum == end) {
                return;
            }

            if (feeArr[city.arriveCityNum] < city.busFee) continue;

            for (City nextCity : graph[city.arriveCityNum]) {
                if (feeArr[nextCity.arriveCityNum] > city.busFee + nextCity.busFee) {
                    feeArr[nextCity.arriveCityNum] = city.busFee + nextCity.busFee;

                    pq.offer(new City(nextCity.arriveCityNum, feeArr[nextCity.arriveCityNum]));
                }
            }
        }
    }
}