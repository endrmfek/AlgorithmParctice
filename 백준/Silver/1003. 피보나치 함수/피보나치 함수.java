import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Integer[][] dp;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp = new Integer[41][2];

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        int tc = Integer.parseInt(br.readLine());
        
        while(tc-- > 0) {
            int num = Integer.parseInt(br.readLine());
            fibo(num);
            System.out.println(dp[num][0] + " " + dp[num][1]);
        }
    }

    public static Integer[] fibo(int num) {

        if(dp[num][0] == null || dp[num][1] == null) {
            dp[num][0] = fibo(num-1)[0] + fibo(num-2)[0];
            dp[num][1] = fibo(num-1)[1] + fibo(num-2)[1];
        }

        return dp[num];
    }
}