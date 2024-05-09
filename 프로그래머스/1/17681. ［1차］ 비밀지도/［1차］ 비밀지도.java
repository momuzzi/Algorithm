class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i = 0; i < n; i++) {
            String res = Integer.toBinaryString(arr1[i] | arr2[i]);
            res = "0".repeat(n - res.length()) + res;
            answer[i] = res.replaceAll("0", " ").replaceAll("1", "#");
        }
        
        return answer;
    }
}