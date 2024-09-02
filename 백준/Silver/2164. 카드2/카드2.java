import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedList<Integer> q = new LinkedList<>();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        boolean flag = true;
        while (q.size() > 1) {
            if (flag) {
                q.pop();
                flag = false;
            } else {
                q.add(q.pop());
                flag = true;
            }
        }

        System.out.println(q.pop());
    }
}