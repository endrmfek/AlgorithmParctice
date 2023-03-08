import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static char[] a;
	static char[] b;
	static StringBuilder text;
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		a = br.readLine().toCharArray();
		b = br.readLine().toCharArray();
		dp = new int[a.length + 1][b.length + 1];
		text = new StringBuilder();
		
		//dp테이블 초기화
		for(int i=1; i<a.length + 1 ; i++) {
			for(int j=1; j<b.length +1; j++) {
				if(a[i-1] == b[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1; 	//값이 같으면 대각선에서 +1 
				}else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]); //다르면 왼쪽 또는 위에서 큰값 가져와.
				}
			}
		}
		
		// longest common subseqeunce? 구해야지.
		System.out.println(dp[a.length][b.length]);
		
		//글자구해야지.
		getText(a.length, b.length); //->글자가 근데 거꾸로나옴. 뒤집어야돼
		System.out.println(text.reverse().toString());
		
	}
	
	private static void getText(int r, int c) {
		if( r== 0 || c ==0) return; //이게 중요하지.
		
		if(a[r-1] == b[c-1]) { //일치하면
			text.append(a[r-1]);
			getText(r-1, c-1); // 한칸 앞으로.
		} else { //다르면
			if(dp[r-1][c] > dp[r][c-1]) { //큰수쪽으로 이동.
				getText(r-1, c);
			} else {
				getText(r, c-1);
			}
		}
	}
}
