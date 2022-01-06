package implement;

import java.util.Scanner;

public class Night {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String data = sc.nextLine();
		int row = data.charAt(1) - '0';
		int col = data.charAt(0) - 'a' + 1;
		
		int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
	    int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
		
		int result =0;
		for(int i=0; i<8; i++) {
			int nx = row+dx[i];
			int ny = col+dy[i];
			
			if(nx>=1 && nx<=8 && ny>=1 && ny<=8) {
				result +=1 ;
			}
		}
		
		System.out.println(result);
	}
}
