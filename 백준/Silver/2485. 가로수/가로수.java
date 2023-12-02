import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] data = new int[N];

        for(int i=0; i<N; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(data);

        int gcd = 0;

        for(int i=0; i<N-1; i++) {
            int dist = data[i+1] - data[i];
            gcd = getGcd(dist, gcd);
        }

        int result = ((data[N-1]-data[0])/gcd + 1 - (data.length));
        System.out.println(result);
    }

    public static int getGcd(int big, int small) {
        if (small == 0) {
            return big;
        }
        return getGcd(small, big%small);
    }

}