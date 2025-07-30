class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        boolean[][] arr = new boolean[n + 1][n + 1];
        
        for (int i = 0; i < results.length; i++) {
            arr[results[i][0]][results[i][1]] = true;
        }
        
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (arr[i][k] && arr[k][j]) {
                        arr[i][j] = true;
                    }
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            int win = 0;
            int lose = 0;
            for (int j = 1; j <= n; j++) {
                if (arr[i][j]) win++;
                if (arr[j][i]) lose++;
            }
            
            if (win + lose == n - 1) answer++;
        }
        
        return answer;
    }
}