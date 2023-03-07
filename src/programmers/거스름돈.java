package programmers;

public class 거스름돈 {
    //최소 방법 이런게 아니라
    //n원을 거슬러 줄 수 있는 방법의 수 -> 전체 다 구하면돼.
    public int solution(int n, int[] money) {
        int answer = 0;
        int[] dp = new int[n+1];
        dp[0] = 1; //왜 1일까?

        for(int m : money) {
            //각 돈마다 만들 수 있는 경우의 수 모두 구해
            for(int i=m; i<=n; i++) {
                dp[i] += dp[i-m];
                dp[i] = dp[i] % 1000000007;
            }
        }
        return dp[n];
    }
}
