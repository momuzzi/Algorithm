import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        
        LinkedList<int[]> q = new LinkedList<>();
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        q.offerLast(new int[] {0, 0});
        
        while (!q.isEmpty()) {
            int[] poll = q.pollFirst();
            
            for (int i = 0; i < 4; i++) {
                int moveX = poll[0] + dx[i];
                int moveY = poll[1] + dy[i];
                
                if (moveX < 0 || moveY < 0 || moveX >= maps.length || moveY >= maps[0].length) continue;
                
                if (maps[moveX][moveY] == 1) {
                    maps[moveX][moveY] = maps[poll[0]][poll[1]] + 1;
                    q.offerLast(new int[] {moveX, moveY});
                }
            }
            
            if (maps[maps.length - 1][maps[0].length - 1] != 1) break;
        }
        
        if (maps[maps.length - 1][maps[0].length - 1] != 1) {
            return maps[maps.length - 1][maps[0].length - 1];
        }
        
        return answer;
    }
}