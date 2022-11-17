import java.util.stream.IntStream;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int length = triangle.length;
        int[][] dp = new int[length][length];
        dp[0][0] = triangle[0][0];
        
        for(int i=1; i<length; i++) { // 세로
            for(int j=0; j<triangle[i].length; j++) {
                if( i==j) { // 오른쪽 끝일거아니야
                    dp[i][j] = triangle[i][j] + dp[i-1][j-1];
                } else if (j==0) {
                    dp[i][j] = triangle[i][j] + dp[i-1][j];
                } else {
                    dp[i][j] = Math.max((triangle[i][j] + dp[i-1][j-1]) , (triangle[i][j] + dp[i-1][j]));
                }
            }
        }
        return IntStream.of(dp[length-1]).max().getAsInt();
    }
}