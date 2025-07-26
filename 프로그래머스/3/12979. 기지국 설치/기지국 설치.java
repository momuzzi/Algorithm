class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int range = 2 * w + 1;
        int now = 1;
        for (int i = 0; i < stations.length; i++) {
            int loc = stations[i];
            int headLoc = loc - w;
            int tailLoc = loc + w;
            
            if (now < headLoc) {
                int dif = headLoc - now;
                int mok = dif / range;
                int mod = dif % range;
                
                if (mod != 0) {
                    answer += mok + 1;
                } else {
                    answer += mok;
                }
            }
            
            now = tailLoc + 1;
        }
        
        if (now <= n) {
            int dif = n - now + 1;
            int mok = dif / range;
            int mod = dif % range;
                
            if (mod != 0) {
                answer += mok + 1;
            } else {
               answer += mok;
            }
        }
        
        return answer;
    }
}