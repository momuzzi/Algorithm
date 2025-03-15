import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] An;
    static int[] op; // [0]: 덧셈, [1]: 뺄셈, [2]: 곱셈, [3]: 나눗셈 의 개수를 저장
    static char[] getOp;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        An = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            An[i] = Integer.parseInt(st.nextToken());
        }

        op = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        getOp = new char[N - 1];

    }

    static void solve() {
        dfs(0);
        System.out.print(max + "\n" + min);
    }

    static void dfs(int depth) {
        if (depth == getOp.length) {
            int result = calculate();

            min = Math.min(min, result);
            max = Math.max(max, result);

            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i] -= 1;
                char choiceOp = '+';

                if (i == 1) {
                    choiceOp = '-';
                }

                if (i == 2) {
                    choiceOp = '*';
                }

                if (i == 3) {
                    choiceOp = '/';
                }

                getOp[depth] = choiceOp;
                dfs(depth + 1);
                op[i] += 1;
            }
        }
    }

    static int calculate() {
        int AnIdx = 1;
        int opIdx = 0;
        int result = An[0];
        while (AnIdx < N) {
            char op = getOp[opIdx];

            if (op == '+') {
                result += An[AnIdx];
            }

            if (op == '-') {
                result -= An[AnIdx];
            }

            if (op == '*') {
                result *= An[AnIdx];
            }

            if (op == '/') {
                if (result < 0) {
                    result = -(-result / An[AnIdx]);
                } else {
                    result = result / An[AnIdx];
                }
            }

            opIdx++;
            AnIdx++;
        }

        return result;
    }
}