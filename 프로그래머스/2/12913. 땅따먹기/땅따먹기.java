class Solution {
    
    int solution(int[][] land) {
        int[][] dp = new int[land.length][4];
        
        for (int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i];
        }
        
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                int beforeMax = 0;
                for (int k = 0; k < 4; k++) {
                    if (j == k) continue;
                    
                    beforeMax = Math.max(beforeMax, dp[i - 1][k]);
                }
                dp[i][j] = land[i][j] + beforeMax;
            }
        }
        
        int max = 0;
        for (int i : dp[land.length - 1]) {
            max = Math.max(max, i);
        }
        
        return max;
    }
    
    
}