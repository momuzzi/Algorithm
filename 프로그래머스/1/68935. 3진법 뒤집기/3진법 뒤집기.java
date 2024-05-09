class Solution {
    public int solution(int n) {
        int answer = 0;
        
        StringBuilder stb = new StringBuilder();
        
        while (n > 0) {
            int r = n % 3;
            stb.append(r);
            n /= 3;
        }
        
        String st = stb.toString();
        int power = 0;
        
        for (int i = st.length() - 1; i >= 0; i--) {
            answer += Character.getNumericValue(st.charAt(i)) * Math.pow(3, power);
            power++;
        }
        
        return answer;
    }
}