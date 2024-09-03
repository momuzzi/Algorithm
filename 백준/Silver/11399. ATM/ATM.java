import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(reader.readLine());

        ArrayList<Integer> list = new ArrayList<>();

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");

        while (tokenizer.hasMoreTokens()) {
            list.add(Integer.parseInt(tokenizer.nextToken()));
        }

        Collections.sort(list);

        int totalTime = 0;
        ArrayList<Integer> timeList = new ArrayList<>();
        for (int personalTime : list) {
            totalTime += personalTime;
            timeList.add(totalTime);
        }

        totalTime = 0;
        for (int time : timeList) {
            totalTime += time;
        }

        System.out.print(totalTime);
    }
}