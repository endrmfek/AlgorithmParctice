package backtracking;

import java.util.Scanner;

public class N_Queen {
	public static int[] arr;
	public static int N;
	public static int count = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		
		nQueen(0);
		System.out.println(count);
		
	}
	
	private static void nQueen(int depth) {
		if(depth == N) {
			count++;
			return;
		}
		
		for(int i=0; i<N; i++) { //각 열의 행을 확인하는 작업.
			arr[depth] = i;
			
			if(possibility(depth)) { //놓을 수 있을때 재귀
				nQueen(depth+1);
			}
		}
		
	}
	
	private static boolean possibility(int col) {
		for(int i=0; i<col; i++) {
			
			if(arr[col] == arr[i]) { //행이 같으면
				return false;
			}
			
			else if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])) { //대각선 (두 점의 행의 차이와 열의 차이가 같으면)
				return false;
			}
		}
		
		return true;
	}
	
	
}
