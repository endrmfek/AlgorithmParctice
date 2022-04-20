package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1389 {
	static int n,m;
	static int distance[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		distance = new int[n+1][n+1];
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(i==j) distance[i][j] = 0;
				else distance[i][j] = 10000001;
			}
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			distance[start][end] = 1;
			distance[end][start] = 1; //양방향.
		}
		
		//플로이드 워셜 시작
		for(int k=1; k<n+1; k++) {
			for(int i=1; i<n+1; i++) {
				for(int j=1; j<n+1; j++) {
					if(distance[i][j] > distance[i][k] + distance[k][j]) {
						distance[i][j] = distance[i][k] + distance[k][j];
					}
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		int result = -1;
		
		for(int i=1; i<=n; i++) {
			
			int temp = 0;
			for(int j=1; j<=n; j++) {
				temp = temp + distance[i][j];	//각 행의 합
			}
			
			if(min > temp) { //행의 값이 가장 작은거 골라서
				min = temp;
				result = i;	//그거 인덱스 저장
			}
		}
		
		System.out.println(result);
		
	}
}
