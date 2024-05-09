class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] num = {"zero", "one", "two", "three", "four"
                        ,"five", "six", "seven", "eight", "nine"};
        String str = s;
        
        for (int i = 0; i < num.length; i++) {
            str = str.replace(num[i], Integer.toString(i));
        } 
        answer = Integer.parseInt(str);
        
        return answer;
    }
}