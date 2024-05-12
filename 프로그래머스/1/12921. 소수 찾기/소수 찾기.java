class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] arr = new int[n + 1];
        
        arr[0] = arr[1] = 0;
        
        //arr 배열에 인덱스 번호와 매칭시켜 정수 값 저장
        for (int i = 2; i <= n; i++) {
            arr[i] = i;
        }
        
        //에라토스테네스의 체
         for (int i = 2; i <= (int) Math.sqrt(n); i++) {             
            for (int j = i+i ; j <= n; j+=i) {  
                arr[j] = 0; 
            }
        }
        
        
        //arr[index]의 값이 0이 아닌 값 카운팅
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                answer++;
            }
        }
         
        return answer;
    }
}
//         int answer = n - 1;
        
//         for (int i = 2; i <= n; i++) {
//             for (int j = 2; j < i; j++) {
//                 if (i % j == 0) {
//                     answer--;
//                     break;
//                 }
//             }
//         }
        
//         return answer;