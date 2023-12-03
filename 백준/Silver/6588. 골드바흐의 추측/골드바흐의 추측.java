import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] primes = getPrime(1000001);

        while(true) {
            N = Integer.parseInt(br.readLine());
            if(N == 0) {
                break;
            }
            solution(N, primes);
        }

    }

    public static void solution(int num, boolean[] primes) {
        boolean flag = false;
        for(int i=2; i<num/2+1; i++) {
            if(!primes[i] && !primes[num-i]) {
                System.out.println(num + " = " + i + " + " + (num-i));
                flag = true;
                return;
            }
        }
        if(!flag) {
            System.out.println("Goldbach's conjecture is wrong.");
        }
    }

    public static boolean[] getPrime(int n) {
        boolean[] nums = new boolean[n];

        nums[0] = true;
        nums[1] = true;

        for(int i=2; i<Math.sqrt(n)+1; i++) {
            if (nums[i]) {
                continue;
            }
            for(int j=i*i; j<n; j+=i) {
                nums[j] = true;
            }
        }

        return nums;
    }

    public static int getGcd(int big, int small) {
        if (small == 0) {
            return big;
        }
        return getGcd(small, big%small);
    }

}