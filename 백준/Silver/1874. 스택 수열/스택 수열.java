import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        StringBuilder builder = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int initNum = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= initNum; i++) {
            stack.push(i);
            builder.append("+").append("\n");
        }

        stack.pop();
        builder.append("-").append("\n");

        int pushCnt = initNum;
        for (int i = 1; i <= n - 1; i++) {
            int num = Integer.parseInt(reader.readLine());

            if (pushCnt < num) {
                while (pushCnt != num) {
                    pushCnt++;
                    stack.push(pushCnt);
                    builder.append("+").append("\n");
                }
                stack.pop();
                builder.append("-").append("\n");
            } else if (pushCnt > num) {
                if (stack.peek() >= num) {
                    stack.pop();
                    builder.append("-").append("\n");
                } else {
                    System.out.print("NO");
                    return;
                }
            }
        }

        System.out.print(builder);
    }
}