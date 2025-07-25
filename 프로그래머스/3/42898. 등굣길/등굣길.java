class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < puddles.length; i++) {
            int x = puddles[i][0];
            int y = puddles[i][1];
            dp[y][x] = -1;
        }

        dp[1][1] = 1;

        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= m; x++) {
                if (y == 1 && x == 1) continue;
                if (dp[y][x] == -1) continue;

                int left = dp[y][x - 1] == -1 ? 0 : dp[y][x - 1];
                int top = dp[y - 1][x] == -1 ? 0 : dp[y - 1][x];

                dp[y][x] = (left + top) % 1_000_000_007;
            }
        }

        answer = dp[n][m];
        return answer;
    }
}
