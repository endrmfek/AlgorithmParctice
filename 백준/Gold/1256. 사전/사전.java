import java.util.Scanner;

//사전
//k번째 문자열이 뭔지 어떻게알아?
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] dp = new int[202][202];

        for(int i=0; i<=200; i++) { // 상향식 dp
            for(int j=0; j<=i; j++) {
                if(j==0 || j==i) dp[i][j] = 1; // 아무것도 안고르거나, n 개중 n개 고르는 경우의 수는 1
                else {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                    if(dp[i][j] > 1000000000) dp[i][j] = 1000000001;
                }
            }
        }

        if(dp[n+m][m] < k) { // 만들수있는 총 경우의 수 보다 k가 크면
            System.out.println("-1");
        } else {
            while(!(n==0 && m==0)) {
                if(dp[n-1+m][m] >= k) {
//                    System.out.println("n = " + n + ", m = " + m + " dp["+ (n-1+m) +"][" +m + "] = " + dp[n-1+m][m]);
                    System.out.print("a");
                    n--;
                } else { //dp[n-1+m][m] < k
//                    System.out.println("n = " + n + ", m = " + m + " dp["+ (n-1+m) +"][" +m + "] = " + dp[n-1+m][m]);
                    System.out.print("z");
                    k = k - dp[n-1+m][m];
                    m--;
                }
            }
        }
    }
}
