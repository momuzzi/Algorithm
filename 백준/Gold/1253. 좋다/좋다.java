import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
    }
    
    static void solve() {
        int goods = 0;

        for (int i = 0; i < N; i++) {
            int now = arr[i];
            int left = 0;
            int right = N - 1;

            while (left < right) {
                if (arr[left] + arr[right] > now) {
                    right--;
                    continue;
                }

                if (arr[left] + arr[right] < now) {
                    left++;
                    continue;
                }

                if (arr[left] + arr[right] == now) {
                    if (left != i && right != i) {
                        goods++;
                        break;
                    }

                    if (left == i) {
                        left++;
                    }

                    if (right == i) {
                        right--;
                    }
                }
            }
        }

        System.out.print(goods);
    }
}