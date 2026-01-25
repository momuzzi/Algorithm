import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            String[] nAT = br.readLine().split(" ");

            if (nAT[0].equals("1")) {
                int A = Integer.parseInt(nAT[1]);
                int T = Integer.parseInt(nAT[2]);
                if (T - 1 == 0) {
                    sum += A;
                } else {
                    stack.push(new int[]{A, T - 1});
                }
            } else if(!stack.isEmpty()) {
                int[] pop = stack.pop();

                if (pop[1] - 1 == 0) {
                    sum += pop[0];
                } else {
                    stack.push(new int[]{pop[0], pop[1] - 1});
                }
            }
        }

        System.out.print(sum);
    }
}