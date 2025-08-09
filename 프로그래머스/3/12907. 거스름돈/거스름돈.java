import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        Arrays.sort(money);
        
        for (int i = 0; i < money.length; i++) {
            int m = money[i];
            for (int j = 0; j <= n; j++) {
                if (j - m < 0) continue;
                
                dp[j] += dp[j - m];
            }
        }
        
        return dp[n];
    }
}