import java.io.*;
import java.util.*;

public class Main {

    static char[] digitArr = {'2', '3', '4', '5', '6', '7', '8', '9'};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        LinkedList<String> stk = new LinkedList<>();

        int idx = 0;
        while (idx < s.length()) {
            char c = s.charAt(idx);

            if (!isDigit(c)) {
                if (c == 'H') {
                    stk.offerLast("1");
                }

                if (c == 'C') {
                    stk.offerLast("12");
                }

                if (c == 'O') {
                    stk.offerLast("16");
                }

                if (c == '(') {
                    stk.offerLast("(");
                }

                if (c == ')') {
                    int sum = 0;
                    while (true) {
                        String num = stk.pollLast();
                        if (num != "(") {
                            sum += Integer.parseInt(num);
                        } else {
                            stk.offerLast(Integer.toString(sum));
                            break;
                        }
                    }
                }
            } else {
                int num = Integer.parseInt(stk.pollLast());
                
                stk.offerLast(Integer.toString(num * Character.getNumericValue(c)));
            }

            idx++;
        }

        int answer = 0;
        while (!stk.isEmpty()) {
            answer += Integer.parseInt(stk.pollLast());
        }

        System.out.print(answer);
    }

    static boolean isDigit(char c) {
        for (int i = 0; i < digitArr.length; i++) {
            if (c == digitArr[i]) {
                return true;
            }
        }

        return false;
    }
}