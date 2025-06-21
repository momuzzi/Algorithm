import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;
    static List<int[]> list;
    static int[] P = new int[5];
    static int K;
    static Map<Integer, Integer> needTurn;
    
    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));

        list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            list.add(new int[8]);
        }

        for (int i = 1; i <= 4; i++) {
            String str = br.readLine();
            int[] arr = list.get(i);
            for (int j = 0; j < 8; j++) {
                arr[j] = str.charAt(j) - '0';
            }
        }

        K = Integer.parseInt(br.readLine());
    }

    static void solve() throws Exception {
        for (int i = 0; i < K; i++) {
            String[] arr = br.readLine().split(" ");
            int topNum = Integer.parseInt(arr[0]);
            int d = Integer.parseInt(arr[1]);

            needTurn = new HashMap<>();

            needTurn.put(topNum, d);

            left(topNum, d);
            right(topNum, d);

            List<Integer> tNumList = new ArrayList<>(needTurn.keySet());
            Collections.sort(tNumList);

            for (int tNum : tNumList) {
                int td = needTurn.get(tNum);

                if (td == 1) {
                    turnRightIdx(tNum);
                } else {
                    turnLeftIdx(tNum);
                }
            }
        }

        int sum = 0;
        int score = 1;
        for (int i = 1; i < 5; i++) {
            int[] t = list.get(i);
            int sn = t[P[i]];

            if (sn == 1) {
                sum += score;
            }

            score *= 2;
        }

        System.out.print(sum);
    }

    static void left(int topNum, int d) {
        if (topNum > 1) {
            int[] nowTop = list.get(topNum);
            int nowSN = nowTop[getLeftIdx(topNum)];

            int[] leftTop = list.get(topNum - 1);
            int leftSN = leftTop[getRightIdx(topNum - 1)];

            if (nowSN != leftSN) {
                needTurn.put(topNum - 1, -d);
                left(topNum - 1, -d);
            }
        }
    }

    static void right(int topNum, int d) {
        if (topNum < 4) {
            int[] nowTop = list.get(topNum);
            int nowSN = nowTop[getRightIdx(topNum)];

            int[] rightTop = list.get(topNum + 1);
            int rightSN = rightTop[getLeftIdx(topNum + 1)];

            if (nowSN != rightSN) {
                needTurn.put(topNum + 1, -d);
                right(topNum + 1, -d);
            }
        }
    }

    static int getLeftIdx(int topNum) {
        int temp = P[topNum];
        int cnt = 0;
        while (cnt < 2) {
            if (temp - 1 >= 0) {
                temp--;
            } else {
                temp = 7;
            }
            cnt++;
        }

        return temp;
    }

    static int getRightIdx(int topNum) {
        int temp = P[topNum];
        int cnt = 0;
        while (cnt < 2) {
            if (temp + 1 < 8) {
                temp++;
            } else {
                temp = 0;
            }
            cnt++;
        }

        return temp;
    }

    static void turnLeftIdx(int topNum) {
        if (P[topNum] + 1 < 8) {
            P[topNum]++;
        } else {
            P[topNum] = 0;
        }
    }

    static void turnRightIdx(int topNum) {
        if (P[topNum] - 1 >= 0) {
            P[topNum]--;
        } else {
            P[topNum] = 7;
        }
    }
}