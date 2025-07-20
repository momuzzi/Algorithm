class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        
        for (int i = 1; i <= number; i++) {
            int result = cnt(i);
            
            if (result > limit) {
                answer += power;
            } else {
                answer += result;
            }
        }
        
        return answer;
    }
    
    static int cnt(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count++;
                
                if (n / i != i) {
                    count++;
                }
            }
        }
        
        return count;
    }
}