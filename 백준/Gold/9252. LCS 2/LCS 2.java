import java.io.*;
import java.util.Stack;

public class Main {

    static char[] criteria;
    static char[] target;
    static int[][] dp;
    static Node[][] before;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static class Node {
        int i;
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        criteria = br.readLine().toCharArray();
        target = br.readLine().toCharArray();
        dp = new int[criteria.length + 1][target.length + 1];
        before = new Node[criteria.length + 1][target.length + 1];
    }

    static void solve() {
        for (int i = 1; i <= criteria.length; i++) {
            for (int j = 1; j <= target.length; j++) {
                if (criteria[i - 1] == target[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    before[i][j] = new Node(i - 1, j - 1);
                    continue;
                }

                if (dp[i][j - 1] > dp[i - 1][j]) {
                    dp[i][j] = dp[i][j - 1];
                    before[i][j] = new Node(i, j - 1);
                } else {
                    dp[i][j] = dp[i - 1][j];
                    before[i][j] = new Node(i - 1, j);
                }
            }
        }

        System.out.println(dp[criteria.length][target.length]);
        
        if (dp[criteria.length][target.length] == 0) {
            return;
        }

        StringBuilder sb = new StringBuilder();

        int i = criteria.length;
        int j = target.length;
        Stack<Character> stack = new Stack<>();
        while (true) {
            if (i == 0 || j == 0) {
                break;
            }

            Node node = before[i][j];
            int beforeI = node.i;
            int beforeJ = node.j;

            if (dp[i][j] > dp[beforeI][beforeJ]) {
                stack.push(target[j - 1]);
            }

            i = beforeI;
            j = beforeJ;
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.print(sb);
    }
}