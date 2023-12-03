import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        List<Integer> primes = getPrime(N);
        int left = 0 ,right = 0;
        int sum = 2;
        int answer = 0;
        int size = primes.size();

        while(left < size && right < size) {
            if(sum == N) {
                answer++;
                sum -= primes.get(left);
                left++;
            } else if(sum > N) {
                sum -= primes.get(left);
                left++;
            } else {
                right++;
                if(right >= size) break;
                sum += primes.get(right);
            }
        }
        System.out.println(answer);
    }

    public static List<Integer> getPrime(int n) {
        List<Integer> primes = new ArrayList<>();
        int[] nums = new int[n+1];

        for(int i=2; i<=n; i++) {
            nums[i] = i;
        }

        for(int i=2; i<Math.sqrt(n)+1; i++) {
            if (nums[i] == 0) {
                continue;
            }
            for(int j=i*i; j<=n; j+=i) {
                nums[j] = 0;
            }
        }

        for(int i=2; i<=n; i++) {
            if(nums[i] != 0) {
                primes.add(nums[i]);
            }
        }

        return primes;
    }

}