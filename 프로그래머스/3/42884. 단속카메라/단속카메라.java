import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
        
        int prev = routes[0][1];
        int cnt = 1;
        for (int i = 1; i < routes.length; i++) {
            int start = routes[i][0];
            int end = routes[i][1];
            
            if (start <= prev) {
                prev = Math.min(prev, end);
            } else {
                prev = end;
                cnt++;
            }
        }
            
        return cnt;
    }
}