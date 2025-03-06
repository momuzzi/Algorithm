import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;

    static int[] arr;
    static LinkedList<Integer> dq;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        arr = new int[M];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dq = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            dq.offerLast(i);
        }
    }

    static void solve() {
        int idx = 0;
        int cnt = 0;
        while (idx != M) {

            int num = arr[idx];

            int zeroToTargetLength = 0; // 타깃 앞에있는 원소 갯수
            for (int n : dq) {
                if (num == n) break;

                zeroToTargetLength++;
            }

            int dqSize = dq.size();

            if (dqSize % 2 == 0) {
                if (zeroToTargetLength + 1 > dqSize / 2) {
                    while (dq.peekLast() != num) {
                        Integer pollNum = dq.pollLast();
                        dq.offerFirst(pollNum);
                        cnt++;
                    }

                    dq.pollLast(); // 타깃은 굳이 다시 넣을 필요 없이 cnt만 ++해준다 (맨뒤에서 맨 앞으로 옮기는 작업 후 바로 삭제할 것이기에)
                    cnt++;
                } else {
                    while (dq.peekFirst() != num) {
                        Integer pollNum = dq.pollFirst();
                        dq.offerLast(pollNum);
                        cnt++;
                    }
                    dq.pollFirst(); // 앞에서 쭉 빼는 경우는 타깃 poll할 때는 cnt ++안함.
                }
            } else {
                if (zeroToTargetLength + 1 > dqSize / 2 + 1) {
                    while (dq.peekLast() != num) {
                        Integer pollNum = dq.pollLast();
                        dq.offerFirst(pollNum);
                        cnt++;
                    }

                    dq.pollLast(); // 타깃은 굳이 다시 넣을 필요 없이 cnt만 ++해준다 (맨뒤에서 맨 앞으로 옮기는 작업 후 바로 삭제할 것이기에)
                    cnt++;
                } else {
                    while (dq.peekFirst() != num) {
                        Integer pollNum = dq.pollFirst();
                        dq.offerLast(pollNum);
                        cnt++;
                    }
                    dq.pollFirst(); // 앞에서 쭉 빼는 경우는 타깃 poll할 때는 cnt ++안함.
                }
            }

            idx++;
        }

        System.out.print(cnt);

    }
}