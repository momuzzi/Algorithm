import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;
    static int N;
    static int C;
    static Student[] students;

    static class Student {
        int num;
        int cnt;
        int time;

        public Student(int num, int cnt, int time) {
            this.num = num;
            this.cnt = cnt;
            this.time = time;
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());
        students = new Student[101];
    }

    static void solve() throws Exception {
        List<Student> frame = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            int studentNum = Integer.parseInt(st.nextToken());

            if (students[studentNum] != null) {
                students[studentNum].cnt++;
            } else {
                if (students[studentNum] == null) {
                    students[studentNum] = new Student(studentNum, 1, i);

                    if (frame.size() == N) {
                        frame.sort(new Comparator<Student>() {
                            @Override
                            public int compare(Student o1, Student o2) {
                                if (o1.cnt == o2.cnt) {
                                    return o1.time - o2.time;
                                }
                                return o1.cnt - o2.cnt;
                            }
                        });

                        Student s = frame.remove(0);
                        students[s.num] = null;
                    }

                    frame.add(students[studentNum]);
                }
            }
        }

        frame.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.num - o2.num;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Student s : frame) {
            sb.append(s.num + " ");
        }

        System.out.print(sb);
    }
}