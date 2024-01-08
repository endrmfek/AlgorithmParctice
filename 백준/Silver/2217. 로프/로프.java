import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        //입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] data = new Integer[n];
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }

        //로직
        Arrays.sort(data, Collections.reverseOrder());
        for (int i=0; i<n; i++) {
            result[i] = data[i] * (i + 1);
        }
        System.out.println(Arrays.stream(result).max().getAsInt());
    }
}
