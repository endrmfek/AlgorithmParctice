import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static boolean[] arr;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int big, small;
        if (N>=M) {
            big = N;
            small = M;
        } else {
            big = M;
            small = N;
        }

        System.out.println(gcd(big,small));
        System.out.println(lcm(big,small));
    }

    //최대 공약수
    public static int gcd(int big, int small) {
        if (small == 0) {
            return big;
        }
        return gcd(small, big%small);
    }

    //최소공배수
    public static int lcm(int a, int b) {
        int gcd = gcd(a,b);
        return (a*b) / gcd;
    }
}
