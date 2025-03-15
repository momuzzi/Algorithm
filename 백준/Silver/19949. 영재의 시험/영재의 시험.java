import java.io.*;
import java.util.*;

public class Main {

    static int[] answerArr;
    static int[] myAnswerArr;
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answerArr = new int[10];
        myAnswerArr = new int[10];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            answerArr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        dfs(0);
        System.out.print(cnt);
    }

    static void dfs(int depth) {
        if (depth == 10) {
            calculate();
            return;
        }

        for (int i = 1; i <= 5; i++) {
            if (depth >= 2 && myAnswerArr[depth - 1] == i && myAnswerArr[depth - 1] == myAnswerArr[depth - 2]) continue;

            myAnswerArr[depth] = i;
            dfs(depth + 1);
        }
    }

    static void calculate() {
        int score = 0;
        for (int i = 0; i < 10; i++) {
            if (answerArr[i] == myAnswerArr[i]) score++;
        }

        if (score >= 5) cnt++;
    }
}