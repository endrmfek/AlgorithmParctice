import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num < 2) {
                continue;
            }
            if(isPrime(num)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static boolean isPrime(int number) {
        if(number == 1) {
            return false;
        }

        if(number == 2) {
            return true;
        }

        for(int i=2; i<Math.sqrt(number) + 1; i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }



}
