import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String teamName = br.readLine();
            int memberCnt = Integer.parseInt(br.readLine());

            List<String> members = new ArrayList<>();
            for (int j = 0; j < memberCnt; j++) {
                members.add(br.readLine());
            }

            Collections.sort(members);
            map.put(teamName, members);
        }

        Set<String> teamNames = map.keySet();


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            int kind = Integer.parseInt(br.readLine());

            if (kind == 0) {
                List<String> members = map.get(name);
                for (String member : members) {
                    sb.append(member + "\n");
                }
            } else {
                for (String teamName : teamNames) {
                    List<String> members = map.get(teamName);
                    if (members.contains(name)) {
                        sb.append(teamName + " \n");
                        break;
                    }
                }
            }
        }

        System.out.print(sb);
    }
}