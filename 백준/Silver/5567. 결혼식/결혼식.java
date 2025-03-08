import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static List<Integer>[] arr;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        arr = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);

            arr[a].add(b);
            arr[b].add(a);
        }
    }

    static void solve() {
        Set<Integer> inviteeSet = new HashSet<>();

        List<Integer> sangFriend = arr[1];

        for (Integer num : sangFriend) {
            inviteeSet.add(num);
        }

        Set<Integer> newInviteeSet = new HashSet<>();

        for (Integer num : inviteeSet) {
            List<Integer> sangFriendFriend = arr[num];
            for (Integer num2 : sangFriendFriend) {
                if (!inviteeSet.contains(num2) && num2 != 1) {
                    newInviteeSet.add(num2);
                }
            }
        }

        System.out.print(inviteeSet.size() + newInviteeSet.size());
    }
}