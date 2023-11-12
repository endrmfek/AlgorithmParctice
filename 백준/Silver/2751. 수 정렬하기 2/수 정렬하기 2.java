import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> data = new ArrayList<>();
        for (int i=0; i<n; i++) {
            data.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(data);

        StringBuilder sb = new StringBuilder();
        for (Integer num : data) {
            sb.append(num).append('\n');
        }
        System.out.println(sb);
    }
}
