package programmers;

public class 최적의행렬곱셈 {
    public int solution(int[][] matrix_sizes) {
        int length = matrix_sizes.length;
        int[][] dp = new int[length][length];

        for(int i=0; i<length; i++) {
            for(int j=0; j<length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        //dp[i][j] = i번째 행렬부터 j번째 행렬까지 최소 연산 횟수.
        //length = 5일때
        for(int i=0; i<length; i++) {
            for(int j=0; j<length-i; j++) { // i=0;일때 j=0부터 5까지 경우의 수? , i=3일때 j=0부터 2까지 경우의수.
                int a = j;
                int b = j+i;
                if(a==b) dp[a][b] = 0;
                else {
                    for(int k=a; k<b; k++) {
                        dp[a][b] = Math.min(dp[a][b] , dp[a][k]+dp[k+1][b] + matrix_sizes[a][0] * matrix_sizes[k][1] * matrix_sizes[b][1]);
                    }
                }
            }
        }

        return dp[0][length-1];
    }

    // a*b  b*c -> a*b*c
    // 5*3 3*10 10*6
    // 150 + 300 -> 5*10 10 6
    public int solution2(int[][] matrix_sizes) {
        int length = matrix_sizes.length;
        int[][] dp = new int[length][length];

        for(int i=0; i<length; i++) {
            for(int j=0; j<length; j++) {
                dp[i][j] = Integer.MAX_VALUE; // 최소값을 찾아야되거든.
            }
        }

        for(int i=0; i<length; i++) {
            for(int j=0; j< length-i; j++) {
                int a = j;
                int b = j+i;
                if(a==b) dp[a][b] = 0;
                else {
                    for(int k=a; k<b; k++) {
                        dp[a][b] = Math.min(dp[a][b] , dp[a][k] + dp[k+1][b] +matrix_sizes[a][0]* matrix_sizes[k][1]* matrix_sizes[b][1]);
                    }
                }
            }
        }

        return dp[0][length-1];
    }
}
