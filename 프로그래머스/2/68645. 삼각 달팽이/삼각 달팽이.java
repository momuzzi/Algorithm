class Solution {
    
    public int[] solution(int n) {
        int totalCnt = n * (n + 1) / 2;
        
        int[][] graph = new int[n][n];
        graph[0][0] = 1;
        
        int[] dx = new int[] {1, 0, -1};
        int[] dy = new int[] {0, 1, -1};
        int cnt = 1;
        int x = 0;
        int y = 0;
        int dir = 0;
        while (cnt <= totalCnt) {
            graph[x][y] = cnt++;
            
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if (nx >= n || ny >= n || nx < 0 || ny < 0 || graph[nx][ny] != 0) {
                dir = (dir + 1) % 3;
            }
            
            x += dx[dir];
            y += dy[dir];
        }
        
        int[] answer = new int[totalCnt];
        
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx] = graph[i][j];
                idx++;
            }
        }
        
        return answer;
    }
}