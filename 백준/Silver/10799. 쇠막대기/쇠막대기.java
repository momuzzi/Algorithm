import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = rd.readLine();
        char[] arr = input.toCharArray();

        Deque<Character> stack = new ArrayDeque<>();

        int cnt = 0; // 쇠 막대기 갯수
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(' && arr[i + 1] == '(') { // 쇠 막대 시작인 경우
                stack.addLast(arr[i]);
                cnt++;
            }

            if (arr[i] == ')') {
                if (arr[i - 1] == '(') { // 레이저인 경우
                    cnt += stack.size();
                } else { // 막대 오른쪽 끝인 경우
                    stack.pollLast();
                }
            }
        }

        System.out.print(cnt);
    }
}