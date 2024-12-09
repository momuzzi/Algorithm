import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Float> gradeMap = new HashMap<>();
        gradeMap.put("A+", 4.5f);
        gradeMap.put("A0", 4.0f);
        gradeMap.put("B+", 3.5f);
        gradeMap.put("B0", 3.0f);
        gradeMap.put("C+", 2.5f);
        gradeMap.put("C0", 2.0f);
        gradeMap.put("D+", 1.5f);
        gradeMap.put("D0", 1.0f);
        gradeMap.put("F", 0.0f);

        float allPoint = 0;
        float allTimes = 0;

        for (int i = 0; i < 20; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            String subjectName = tokenizer.nextToken();
            float times = Float.parseFloat(tokenizer.nextToken());
            String grade = tokenizer.nextToken();

            if (!grade.equals("P")) {
                allTimes += times;
                Float point = gradeMap.get(grade);
                allPoint += point * times;
            }

        }

        System.out.print(allPoint / allTimes);
    }
}