class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long l = 1l;
        long h = 1_000_000_000_000_000_000l;
        
        while (l <= h) {
            long m = (l + h) / 2;
            
            if (canPass(m, n, times)) {
                h = m - 1;
                answer = m;
            } else {
                l = m + 1;
            }
        }
        
        return answer;
    }
    
    static boolean canPass(long m, int n, int[] times) {
        long people = 0;
        
        for (int time : times) {
            people += m / time;
            
            if (people >= n) return true;
        }
        
        return false;
    }
}