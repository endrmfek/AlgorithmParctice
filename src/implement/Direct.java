package implement;

import java.util.Scanner;

public class Direct {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine(); // 버퍼 비워야돼;.
		String[] plans = sc.nextLine().split(" ");
		int x=1, y=1;
		
		int[] dx = {0,0,-1,1};
		int[] dy = {-1,1,0,0};
		char[] dir = {'L' ,'R','U','D'};
		
		for(int i=0; i<plans.length; i++) {
			char plan = plans[i].charAt(0); //String to char
			
			int nx =-1, ny=-1;
			
			for(int j=0; j<4; j++) {
				if(plan == dir[j]) { //방향이 맞으면
					nx = x + dx[j]; // 그 방향으로 이동
					ny = y + dy[j];
				}
			}
			
			if (nx <1 || ny <1 || nx >n || ny>n) continue;
			
			x= nx;
			y= ny;
		}
		
		System.out.println(x + " " + y);
	}
}
