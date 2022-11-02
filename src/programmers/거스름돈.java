package programmers;

public class 거스름돈 {
    //방법의 수??..
    //1,000,000,007 을 나눠라.
    //dp잖아 이거.
    public int solution(int n, int[] money) {
        int answer = 0;
        //1,2,5 <- 하나도 겹치는게 없어..
        int[] dp = new int[n+1];
        dp[0] = 1; // 0원을 뭐어떻게 할건디?..

        for(int m : money) {
            for(int i=m; i<=n; i++) {
                //dp는 항상 그 전 답을 알고있다고 가정하고 풀어야됨.
                dp[i] += dp[i-m];
                dp[i] = dp[i] % 1000000007;
            }
        }

        return dp[n];
    }
}
