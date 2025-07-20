class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int total = brown + yellow; // 전체 칸
        
        for (int i = 1; i <= total; i++) {
            if (total % i == 0) {
                int c = i; // 세로
                int r = total / i; // 가로
                
                int sum = r * 2 + 2 * (c - 2);
                
                if (sum == brown) {
                    answer[0] = r;
                    answer[1] = c;
                    break;
                }
            } 
        }
        
        return answer;
    }
}