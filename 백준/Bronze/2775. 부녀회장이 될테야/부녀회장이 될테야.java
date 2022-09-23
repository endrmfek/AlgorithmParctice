import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] dp = new int[15][15];
		//초기값 설정
		for(int i=0; i<15; i++) {
			dp[i][1] =1; // i층 1호실은 1명만살고
			dp[0][i] =i; //0층 i호실은 i명
		}
		//dp값 설정
		for(int i=1; i<15; i++) { //1층부터 14층까지
			for(int j=2; j<15; j++) { // 2호부터 14호까지
				//우리층 옆호 + 아래층 우리호
				dp[i][j] = dp[i][j-1] + dp[i-1][j];
			}
		}
		int tc = sc.nextInt();
		while(tc-- > 0) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			System.out.println(dp[k][n]);
		}
		
	}
}
