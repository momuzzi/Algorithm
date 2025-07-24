class Solution {
    
    static boolean[] visit;
    static int answer = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        visit = new boolean[words.length];
        
        dfs(0, begin, target, words);
        
        if (answer == Integer.MAX_VALUE) {
            answer = 0;
        }
        
        return answer;
    }
    
    static void dfs(int depth, String now, String target, String[] words) {
        if (now.equals(target)) {
            answer = Math.min(answer, depth);
            return;
        }
        
        if (depth == words.length) {
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (!visit[i] && match(now, words[i])) {
                visit[i] = true;
                dfs(depth + 1, words[i], target, words);
                visit[i] = false;
            }
        }
    }
    
    static boolean match(String from, String to) {
        int dif = 0;
        for (int i = 0; i < from.length(); i++) {    
            if (from.charAt(i) != to.charAt(i)) {
                dif++;
            }
            
            if (dif == 2) return false;
        }
        
        return true;
    }
}