import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[x] = 0;
        
        for (int i = x + 1; i <= y; i++) {
            int min = Integer.MAX_VALUE;    
            
            if (i % 2 == 0 && i / 2 >= 1 && dp[i / 2] != Integer.MAX_VALUE) {
                min = Math.min(min, dp[i / 2]);
            }
            
            if (i % 3 == 0 && i / 3 >= 1 && dp[i / 3] != Integer.MAX_VALUE) {
                min = Math.min(min, dp[i / 3]);
            } 
            
            if (i - n >= 1 && dp[i - n] != Integer.MAX_VALUE) {
                min = Math.min(min, dp[i - n]);
            }
            
            if (min != Integer.MAX_VALUE) dp[i] = min + 1; 
        }
                
        return dp[y] == Integer.MAX_VALUE ? -1 : dp[y];
    }
}