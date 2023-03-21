import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int testCase;
	static int n,m,k;
	static int[][] data = new int[51][51];
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int count = 0;
	public static boolean dfs(int x, int y) {
		if(x<0 || x>=n || y<0 || y>=m ) {
			return false;
		}
		
		if(data[x][y] == 1) {
			
			data[x][y] = 2;
			
			dfs(x+1,y);
			dfs(x,y+1);
			dfs(x-1,y);
			dfs(x,y-1);
			
			return true;
		}
		
		return false;
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		testCase = sc.nextInt();
		
		for(int tc=0; tc<testCase; tc++) {
			n = sc.nextInt();
			m = sc.nextInt();
			k = sc.nextInt();
			
			for(int i=0; i<k; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				data[x][y] = 1;
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(dfs(i,j)) {
						count++;
					}
				}
			}
			
			System.out.println(count);
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++){
					data[i][j] = 0;
				}
			}
			count = 0;
		}
	}
}
