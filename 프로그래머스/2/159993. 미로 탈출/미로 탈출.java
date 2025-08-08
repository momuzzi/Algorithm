import java.util.*;

class Solution {
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(String[] maps) {                
        int[] S = new int[3];
        for (int i = 0; i < maps.length; i++) {
            String row = maps[i];
            int sLoc = row.indexOf("S");
            
            if (sLoc != -1) {
                S[0] = i;
                S[1] = sLoc; 
            }
        }
        
        int[] findL = bfs(S, 'L', maps, new boolean[maps.length][maps[0].length()]);
        
        if (findL.length == 1) return -1;
        
        int[] L = new int[3];
        L[0] = findL[0];
        L[1] = findL[1];
        
        int[] findE = bfs(L, 'E', maps, new boolean[maps.length][maps[0].length()]);
        
        if (findE.length == 1) return -1;
        
        return findL[2] + findE[2];
    }
    
    static int[] bfs(int[] start, char target, String[] maps, boolean[][] visit) {
        LinkedList<int[]> q = new LinkedList<>();
        q.offerLast(start);
        visit[start[0]][start[1]] = true;
        
        while (!q.isEmpty()) {
            int[] now = q.pollFirst();
            
            String nowS = maps[now[0]];
            if (nowS.charAt(now[1]) == target) return now;
            
            for (int i = 0; i < 4; i++) {
                int moveX = now[0] + dx[i];
                int moveY = now[1] + dy[i];
                
                if (moveX < 0 || moveY < 0 || moveX >= visit.length || moveY >= visit[0].length) continue;
                
                String s = maps[moveX];
                if (s.charAt(moveY) != 'X' && !visit[moveX][moveY]) {
                    visit[moveX][moveY] = true;
                    q.offerLast(new int[] {moveX, moveY, now[2] + 1});
                }
            }
        }
        
        return new int[1];
    }
}