import java.util.*;

class Solution {
    
    static int totalDistance;
    
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        totalDistance = distance;
        
        Arrays.sort(rocks);

        int l = 1;
        int h = distance;
        while (l <= h) {
            int m = (l + h) / 2;
            
            if (canDelete(m, rocks, n)) {
                l = m + 1;
                answer = m;
            } else {
                h = m - 1;
            }
        }
        
        return answer;
    }
    
    static boolean canDelete(int d, int[] rocks, int n) {
        int delete = 0;
        
        int beforeRock = 0;
        for (int i = 0; i < rocks.length; i++) {
            if (rocks[i] - beforeRock < d) {
                delete++;
            } else {
                beforeRock = rocks[i];
            }
        }
        
        if (totalDistance - beforeRock < d) {
            delete++;
        }
        
        return delete <= n;
    }
}