package programmers.implement;

public class 점프와순간이동 {
    //건전지 최솟값.
    //dp문제임.
    public static int solutionFail(int n) { // 실패
        int ans = 0;
        //매 순간 갈 수 있는 경우의 수
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1; // 1로 갈수 있는 경우의 수
        dp[2] = 1; // min(dp[i-1]+1 , dp[i/2])
        for(int i=3; i<=n; i++) {
            // dp[1] = 1 dp[2] = 1 dp[3] = 2 dp[4] = 1 dp[5] = 2 dp[6] = 2
            if(i%2 != 0) {
                dp[i] = dp[i-1]+1;
            } else {
                dp[i] = Math.min(dp[i-1]+1 , dp[i/2]);
            }
        }
        return dp[n];
    }

    public static int solution(int n) { //top -down
        int answer = 0;
        //매 순간 갈 수 있는 경우의 수

        while(n != 0) {
            if(n%2 == 0) {
                n = n/2;
            } else {
                n--;
                answer++;
            }
        }
        return answer++;
    }

    public static void main(String[] args) {
        System.out.println(solution(1000000000));
    }
}
