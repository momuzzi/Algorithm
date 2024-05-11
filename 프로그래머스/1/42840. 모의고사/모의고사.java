// 정답 배열이랑 각 수포자의 정답이랑 인덱스별로 해서 비교해서 수가 똑같으면 카운트해놓고
// 마지막에 가장 많이 맞춘 수포자를 반환
// 가장 많이 맞춘 수포자가 여러명이면 오름차순해서 반환
class Solution {
    public int[] solution(int[] answers) {
        
        int[] a1 = {1, 2, 3, 4, 5}; //인덱스 0~4, 배열 크기 5
        int[] a2 = {2, 1, 2, 3, 2, 4, 2, 5}; //인덱스 0~7, 배열 크기 8
        int[] a3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; //인덱스 0~9, 배열 크기 10
        
        int[] score = {0, 0, 0}; //인덱스 0~2, 배열 크기 3
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == a1[i % 5]) {
                score[0]++;
            }
            if (answers[i] == a2[i % 8]) {
                score[1]++;
            }
            if (answers[i] == a3[i % 10]) {
                score[2]++;
            }
        }
        
        int max = 0;
        int dupCnt = 0;
        for (int num : score) {
            if (num > max) {
                max = num;
                dupCnt = 0;
            }
            else if (num == max) {
                dupCnt++;
            }
        }
        
        int[] answer = new int[dupCnt + 1];
        
        int index = 0;
        for (int i = 0; i < score.length; i++) {
            if (score[i] == max) {
                answer[index] = i + 1;
                index++;
            }
        }
        
        return answer;
    }
}