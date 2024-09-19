import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        int N = Integer.parseInt(reader.readLine());

        List<Member> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            String[] s = reader.readLine().split(" ");
            int age = Integer.parseInt(s[0]);
            int turn = i;
            String name = s[1];

            list.add(new Member(age, turn, name));
        }

        list.sort(new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                if (o1.age == o2.age) {
                    return o1.turn - o2.turn;
                }
                return o1.age - o2.age;
            }
        });

        for (Member member : list) {
            builder.append(member.age).append(" ").append(member.name).append("\n");
        }

        System.out.print(builder);
    }

    static class Member {
        int age;
        int turn;
        String name;

        public Member(int age, int turn, String name) {
            this.age = age;
            this.turn = turn;
            this.name = name;
        }
    }
}