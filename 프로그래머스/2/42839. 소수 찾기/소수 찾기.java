import java.util.*;

class Solution {
    
    static Set<Integer> set = new HashSet<>();
    static int cnt = 0;
    static boolean[] visit;
    
    public int solution(String numbers) {
        
        visit = new boolean[numbers.length()];
        for (int i = 1; i <= numbers.length(); i++) {
            bt(i, 0, new String(), numbers);
        }
        
        return cnt;
    }
    
    static void bt(int l, int depth, String newStr, String numbers) {
        if (l == depth) {
            int num = Integer.parseInt(newStr);
            if (set.add(num) && isPrime(num)) {
                cnt++;
            }
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!visit[i]) {
                visit[i] = true;
                bt(l, i + 1, newStr + numbers.substring(i, i + 1), numbers);
                visit[i] = false;
            }
        }
    }
    
    static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        
        if (num % 2 == 0) return false;
        
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) return false;
        }
        
        return true;
    }
}