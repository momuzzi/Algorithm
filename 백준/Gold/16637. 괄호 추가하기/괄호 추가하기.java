import java.io.*;

public class Main {
    
    static int N;
    static char[] arr;
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = br.readLine().toCharArray();

        func(1, arr[0] - '0');

        System.out.print(ans);
    }

    static void func(int idx, int num) {
        if (idx == N) {
            ans = Math.max(ans, num);
            return;
        }

        if (arr[idx] == '+') {
            func(idx + 2, num + (arr[idx + 1] - '0'));

            if (idx + 3 < N) {
                int n = num;
                if (arr[idx + 2] == '+') {
                    n += (arr[idx + 1] - '0') + (arr[idx + 3] - '0');
                } else if (arr[idx + 2] == '-') {
                    n += (arr[idx + 1] - '0') - (arr[idx + 3] - '0');
                } else {
                    n += (arr[idx + 1] - '0') * (arr[idx + 3] - '0');
                }

                func(idx + 4, n);
            }
        } else if (arr[idx] == '-') {
            func(idx + 2, num - (arr[idx + 1] - '0'));

            if (idx + 3 < N) {
                int n = num;
                if (arr[idx + 2] == '+') {
                    n -= (arr[idx + 1] - '0') + (arr[idx + 3] - '0');
                } else if (arr[idx + 2] == '-') {
                    n -= (arr[idx + 1] - '0') - (arr[idx + 3] - '0');
                } else {
                    n -= (arr[idx + 1] - '0') * (arr[idx + 3] - '0');
                }

                func(idx + 4, n);
            }
        } else {
            func(idx + 2, num * (arr[idx + 1] - '0'));

            if (idx + 3 < N) {
                int n = num;
                if (arr[idx + 2] == '+') {
                    n *= (arr[idx + 1] - '0') + (arr[idx + 3] - '0');
                } else if (arr[idx + 2] == '-') {
                    n *= (arr[idx + 1] - '0') - (arr[idx + 3] - '0');
                } else {
                    n *= (arr[idx + 1] - '0') * (arr[idx + 3] - '0');
                }

                func(idx + 4, n);
            }
        }
    }
}