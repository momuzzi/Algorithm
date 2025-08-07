class Solution {
    public int solution(int storey) {
        int answer = 0;
                
        String str = "0" + String.valueOf(storey);
        char[] cArr = str.toCharArray();
        
        for (int i = cArr.length - 1; i > 0; i--) {
            int thisNum = cArr[i] - '0';
            
            if (thisNum > 5) {
                cArr[i - 1] += 1;
                answer += 10 - thisNum;
            } else if (thisNum == 5 && cArr[i - 1] - '0' >= 5) {
                cArr[i - 1] += 1;      
                answer += 5;
            } else {
                answer += thisNum;
            }
        }
        
        answer += cArr[0] - '0';
        
        return answer;
    }
}