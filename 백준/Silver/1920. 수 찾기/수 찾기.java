import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int n1 = Integer.parseInt(reader.readLine());
        
        String firstInputList = reader.readLine();

        StringTokenizer tokenizer = new StringTokenizer(firstInputList);

        Set<Integer> firstSet = new HashSet<>();

        while (tokenizer.hasMoreTokens()) {
            firstSet.add(Integer.parseInt(tokenizer.nextToken()));
        }
        
        int n2 = Integer.parseInt(reader.readLine());

        String secondInputList = reader.readLine();

        StringTokenizer tokenizer2 = new StringTokenizer(secondInputList);

        List<Integer> secondList = new ArrayList<>();

        while (tokenizer2.hasMoreTokens()) {
            secondList.add(Integer.parseInt(tokenizer2.nextToken()));
        }

        StringBuilder builder = new StringBuilder();

        Iterator<Integer> iterator = secondList.iterator();
        while (iterator.hasNext()) {
            if (firstSet.contains(iterator.next())) {
                builder.append(1).append("\n");
            } else {
                builder.append(0).append("\n");
            }
        }
        System.out.println(builder.toString());
    }
}