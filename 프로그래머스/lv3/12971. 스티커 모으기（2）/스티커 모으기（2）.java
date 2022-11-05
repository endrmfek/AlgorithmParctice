import java.util.stream.IntStream;
class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        int[] dp = new int[sticker.length];
        int[] dp2 = new int[sticker.length];
        if(sticker.length == 1) {
            return sticker[0];
        }
        //맨 처음 스티커를 뗴는 경우
        dp[0] = sticker[0];
        dp[1] = sticker[0]; //
        for(int i=2; i<dp.length-1; i++) {
            dp[i] = Math.max( dp[i-1] , dp[i-2]+sticker[i] );
        }
        //맨 처음 스티커를 안떼는 경우
        dp2[0] = 0;
        dp2[1] = sticker[1];
        for(int i=2; i<dp.length; i++) {
            dp2[i] = Math.max(dp2[i-1] , dp2[i-2]+sticker[i]);
        }
        // 맨 처음을 방문하면 맨 마지막을 빼는 로직을 어떻게 구해요??

        return Math.max(dp[sticker.length-2] , dp2[sticker.length-1]);
    }

}