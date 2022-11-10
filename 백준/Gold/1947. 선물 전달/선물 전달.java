import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //선물을 나누는 경우의 수.
        Scanner sc = new Scanner(System.in);
        long mod = 1000000000;
        int n = sc.nextInt();
        long[] dp = new long[n+1];
        dp[1] = 0; // 1명이 선물을 나누는경우는 없지.
        if(n>1) {
            dp[2] = 1; // 2명이 선물 나누려면 서로 나눠야돼.
        }


        for(int i=3; i<=n; i++) {
            //i명이 선물을 나누는 경우는 일단
            //A와B가 선물을 나눠야돼.
            //서로 교환하는 경우 dp[i-2]
            //한쪽이 일방적으로 주는경우 dp[i-1]
            //근데 사람이 나 제외하고 n-1명 있으니까.
            dp[i] = (i-1) * (dp[i-2] + dp[i-1]) % mod;
        }
        System.out.println(dp[n]);
    }
}
