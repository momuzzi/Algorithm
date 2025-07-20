class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        int startSection = section[0];
        int endSection = section[0] + m - 1;
        answer++;
        for (int i = 1; i < section.length; i++) {
            if (section[i] > endSection) {
                startSection = section[i];
                endSection = section[i] + m - 1;
                answer++;
            }
        }
        return answer;
    }
}