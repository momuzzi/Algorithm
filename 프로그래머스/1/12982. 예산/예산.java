class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        for (int i = 0; i < d.length; i++) {
            int min = d[i];
            for (int j = i + 1; j < d.length; j++) {
                if (min > d[j]) {
                    min = d[j];
                    d[j] = d[i];
                    d[i] = min;
                }
            }
            
            if ((budget - min) < 0) {
                break;
            }
            
            budget -= min;
            answer++;
        }
        
        return answer;
    }
}