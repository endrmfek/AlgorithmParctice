package programmers.dp;

import java.util.stream.IntStream;

public class 정수삼각형 {
    //대각선 방향으로 한 칸 오른쪽 또는 왼쪽으로만 이동 가능
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
