import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[26];

        String inputStr = rd.readLine();

        for (int i = 0; i < inputStr.length(); i++) {
            int index = inputStr.charAt(i) - '0' - 49;
            arr[index]++;
        }

        for (int num : arr) {
            sb.append(num + " ");
        }

        System.out.print(sb);
    }
}