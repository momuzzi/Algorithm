import java.util.Arrays;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        char c = ' ';
        for (int i = 0; i < strings.length; i++) {
            c = strings[i].charAt(n);
            strings[i] = c + strings[i];
        }
        
        Arrays.sort(strings);
        
        for (int j = 0; j <strings.length; j++) {
            strings[j] = strings[j].substring(1);
        }
        
        answer = strings;
        
        return answer;
    }
}