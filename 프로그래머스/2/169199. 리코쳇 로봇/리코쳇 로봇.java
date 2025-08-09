import java.util.*;

class Solution {
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visit;
    
    public int solution(String[] board) {
        int x = 0;
        int y = 0;
        int yLength = 0;
        for (int i = 0; i < board.length; i++) {
            String str = board[i];
            
            int index = str.indexOf('R');
            
            if (index != -1) {
                x = i;
                y = index;
                yLength = str.length();
                break;
            }
        }
        
        visit = new boolean[board.length][yLength];
        
        return bfs(new int[] {x, y, 0}, board);        
    }
    
    static int bfs(int[] start, String[] board) {
        LinkedList<int[]> q = new LinkedList<>();
        visit[start[0]][start[1]] = true;
        q.offerLast(start);
        
        while (!q.isEmpty()) {
            int[] now = q.pollFirst();
            
            if (board[now[0]].charAt(now[1]) == 'G') return now[2];
            
            for (int i = 0; i < 4; i++) {
                int[] next = go(now[0], now[1], dx[i], dy[i], board);
                
                if (next[0] == now[0] && next[1] == now[1]) continue;
                
                if (!visit[next[0]][next[1]]) {
                    visit[next[0]][next[1]] = true;
                    q.offerLast(new int[] {next[0], next[1], now[2] + 1});
                }
                
            }
        }
        
        return -1;
    }
    
    static int[] go(int nowX, int nowY, int dirX, int dirY, String[] board) {
        
        while (nowX >= 0 && nowY >= 0 
               && nowX < visit.length && nowY < visit[0].length 
               && board[nowX].charAt(nowY) != 'D') {
            nowX += dirX;
            nowY += dirY;
        }
        
        return new int[] {nowX - dirX, nowY - dirY};
    }
}