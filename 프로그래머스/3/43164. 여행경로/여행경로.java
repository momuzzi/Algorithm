import java.util.*;

class Solution {
    
    static boolean[] visit;
    static String result = null;
    
    public String[] solution(String[][] tickets) {
        visit = new boolean[tickets.length];
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        
        bt("ICN", "ICN", 0, tickets);
        
        return result.split(" ");
    }
    
    
    static void bt(String now, String total, int depth, String[][] tickets) {
        if (result != null) return;
        
        if (depth == tickets.length) {
            if (result == null) {
                result = total;
            }
            
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visit[i] && now.equals(tickets[i][0])) {
                visit[i] = true;
                bt(tickets[i][1], total + " " + tickets[i][1], depth + 1, tickets);
                visit[i] = false;
            }
        }
    }
}