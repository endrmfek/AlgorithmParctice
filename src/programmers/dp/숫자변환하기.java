package programmers.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 숫자변환하기 {

    /**
     * x에 n을 더합니다
     * x에 2를 곱합니다.
     * x에 3을 곱합니다.
     */

    //x to y
    public static int solution(int x, int y, int n) {
        int answer = 0;

        int[] dp = new int[y+1];
        for(int i=x; i<=y; i=i+n) {

            // y-n 빼는게 더 클때?
            //
            if( y-n < y/3) {
                if(i-n >= x) {
                    dp[i] =Math.max(dp[i] , dp[i-n] + 1); //3
                }

                if(i % 2 == 0 ) {
                    dp[i] = Math.min(dp[i/2]+1 , dp[i]);
                }

                if(i%3 == 0 ) {
                    dp[i] = Math.min(dp[i/3]+1 , dp[i]);
                }
            } else {
                if(i % 2 == 0 ) {
                    dp[i] = Math.min(dp[i/2]+1 , dp[i]);
                }

                if(i%3 == 0 ) {
                    dp[i] = Math.min(dp[i/3]+1 , dp[i]);
                }

                if(i-n >= x) {
                    dp[i] =Math.min(dp[i] , dp[i-n] + 1); //3
                }
            }

        }

        return (dp[y] == 0) ? -1 : dp[y];
    }

    public static int solution2(int x, int y, int n) {
        int answer = 0;
        int max = 0;



        return answer;
    }



    public static void main(String[] args) {
        System.out.println(solution2(10,40,5));
    }
}
