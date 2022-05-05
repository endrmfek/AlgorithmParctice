package boj;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Boj_1328 { //빌딩 점화식 세울수있냐 ㅋㅋㅋ 애초에 이거 dp로 풀수있냐 ㅋㅋㅋ
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = sc.nextInt();
		int r = sc.nextInt();
		
		long[][][] dp = new long[101][101][101];
		long mod = 1000000007;
		
		//n-1 경우를 알고있을때 n을 생각해봐.
		//dp[n][l][r] -> 건물이 n일때 l에서 보이는거 r에서 보이는거라고 생각했을때
		//가장 작은놈이 들어온다고 가정을해봐. 
		//가장 왼쪽에 올땐 l+1이 되겠지?
		//가장 오른쪽에 올때도 r+1 이겠지.
		//근데 길이가 n인 빌딩숲에 가운데오면 r과 l에 영향이 없겠지 어차피 안보이니까.
		//하지만 경우의수를 구해야되니까 n-2 를 곱해줘야겠지.
		
		dp[1][1][1] = 1; //초기값이지 이건
		for(int i=2; i<=n; i++) {
			for(int j=1; j<=l; j++) {
				for(int k=1; k<=r; k++) {
					dp[i][j][k] = (dp[i-1][j-1][k] + dp[i-1][j][k-1] + dp[i-1][j][k] * (i-2) ) %mod;
				}
			}
		}
		
		System.out.println(dp[n][l][r]);
	}
}
