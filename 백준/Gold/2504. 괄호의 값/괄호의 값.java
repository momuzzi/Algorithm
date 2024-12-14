import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        Deque<Object> stack = new ArrayDeque<>();
        char[] arr = rd.readLine().toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(' || arr[i] == '[') {
                stack.addLast(arr[i]);
                continue;
            }

            if (arr[i] == ')') {
                if (stack.isEmpty()) { // )인데 스택 비어 있는 경우
                    System.out.print(0);
                    return;
                }

                if (stack.peekLast().equals('[')) { // )인데 스택 가장 위가 [인 경우
                    System.out.print(0);
                    return;
                }

                // 위의 모든 경우가 아니면, 숫자 or ( 인 경우임

                // (인 경우
                if (stack.peekLast().equals('(')) {
                    stack.pollLast();
                    stack.addLast(2);
                    continue;
                }

                // 숫자인 경우
                int sum = 0;
                while (stack.peekLast() instanceof Integer) {
                    int popNum = (int) stack.pollLast();

                    sum += popNum;
                }

                // 숫자 다 꺼내고 다음이 (가 아닌 경우 or 스택이 빈 경우
                if (stack.isEmpty() || !stack.peekLast().equals('(')) {
                    System.out.print(0);
                    return;
                }

                stack.pollLast();
                stack.addLast(sum * 2);
                continue;
            }

            if (arr[i] == ']') {
                if (stack.isEmpty()) { // ]인데 스택 비어 있는 경우
                    System.out.print(0);
                    return;
                }

                if (stack.peekLast().equals('(')) { // )인데 스택 가장 위가 (인 경우
                    System.out.print(0);
                    return;
                }

                // 위의 모든 경우가 아니면, 숫자 or [ 인 경우임

                // [인 경우
                if (stack.peekLast().equals('[')) {
                    stack.pollLast();
                    stack.addLast(3);
                    continue;
                }

                // 숫자인 경우
                int sum = 0;
                while (stack.peekLast() instanceof Integer) {
                    int popNum = (int) stack.pollLast();
                    sum += popNum;
                }

                // 숫자 다 꺼내고 다음이 [가 아닌 경우 or 스택이 빈 경우
                if (stack.isEmpty() || !stack.peekLast().equals('[')) {
                    System.out.print(0);
                    return;
                }

                stack.pollLast();
                stack.addLast(sum * 3);
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            Object pop = stack.pollLast();
            if (pop instanceof Character) {
                System.out.print(0);
                return;
            }

            result += (int) pop;
        }

        System.out.print(result);
    }
}