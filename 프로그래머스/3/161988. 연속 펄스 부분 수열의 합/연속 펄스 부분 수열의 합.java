class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        
        long[][] dp = new long[sequence.length][2];
        dp[0][0] = sequence[0];
        dp[0][1] = -sequence[0];
        
        for (int i = 1; i < sequence.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + sequence[i], sequence[i]);
            dp[i][1] = Math.max(dp[i - 1][0] - sequence[i], -sequence[i]);
        }
        
        long max = Long.MIN_VALUE;
        for (long[] arr : dp) {
            long thisMax = Math.max(arr[0], arr[1]);
            max = Math.max(max, thisMax);
        }
        
        return max;
    }
}