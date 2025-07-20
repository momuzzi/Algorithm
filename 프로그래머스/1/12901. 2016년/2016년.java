class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int[] month = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] days = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        
        int totalDays = 0;
        for (int i = 1; i < a; i++) {
            totalDays += month[i];
        }
        
        totalDays += b - 1;
        
        int mod = totalDays % 7;
        
        answer = days[mod];
        return answer;
    }
}