class Solution {
    
    static boolean[] visit;
    static int max = Integer.MIN_VALUE;
    static int minNeedStamina = Integer.MAX_VALUE;
    
    public int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];
        
        for (int i = 0; i < dungeons.length; i++) {
            minNeedStamina = Math.min(minNeedStamina, dungeons[i][0]);
        }
        
        bt(k, dungeons);
        
        return max;
    }
    
    static void bt(int stamina, int[][] dungeons) {
        int cnt = 0;
        for (int i = 0; i < visit.length; i++) {
            if (visit[i]) cnt++;
        }
            
        max = Math.max(max, cnt);
        
        for (int i = 0; i < visit.length; i++) {
            if (!visit[i] && stamina >= dungeons[i][0]) {
                visit[i] = true;
                bt(stamina - dungeons[i][1], dungeons);
                visit[i] = false;
            }
        }
    }
}