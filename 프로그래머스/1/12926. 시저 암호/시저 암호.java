//1. 소문자 a~z = 97 ~ 122
//2. 대문자 A~Z = 65 ~ 90

import java.util.*;

class Solution {
    public String solution(String s, int n) {
        String answer = "";
        int asciCode = 0;
        for (int i = 0; i < s.length(); i++) {
            asciCode = (int) s.charAt(i);
            if (asciCode >= 97 && asciCode <= 122) {
                if (asciCode + n > 122) {
                    asciCode += n - 26;
                }
                else {
                    asciCode += n;
                }
                answer += (char) asciCode;
            }
            else if (asciCode >= 65 && asciCode <= 90) {
                if (asciCode + n > 90) {
                    asciCode += n - 26;
                } else {
                    asciCode += n;
                }
                answer += (char) asciCode;
            }
            else {
                answer += ' ';
            }
        }
        
        return answer;
    }
}