package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_2251 { // 물통 채우기
	static int[] sender = {0,0,1,1,2,2};
	static int[] receiver = {1,2,0,2,0,1};
	static boolean visited[][]; //a , b 만 있으면 c가 유추가 됨.
	static boolean answer[];
	static int[] now;
	
	static class AB{
		int a;
		int b;
		
		public AB(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		now = new int[3];
		now[0] = sc.nextInt();
		now[1] = sc.nextInt();
		now[2] = sc.nextInt();
		
		visited =new boolean[201][201];
		answer = new boolean[201];
		
		bfs();
		
		for(int i=0; i<answer.length; i++) {
			if(answer[i]) System.out.print(i + " ");
		}
	}
	
	private static void bfs() {
		Queue<AB> q = new LinkedList<>();
		q.offer(new AB(0, 0));
		visited[0][0] = true;
		answer[now[2]] = true; // 처음 10
		while(!q.isEmpty())
		{
			AB nowAB = q.poll();
			int a = nowAB.a;
			int b = nowAB.b;
			int c = now[2]-a-b; //유추가 가능함.
			
			for(int i=0; i<6; i++) {
				int[] next = {a,b,c}; // 0,0,10 시작
				next[receiver[i]] += next[sender[i]];
				next[sender[i]] = 0; // 일단 전부 다보내.
				
				if(next[receiver[i]] > now[receiver[i]]) { // 물이 넘친다?
					next[sender[i]] = next[receiver[i]] - now[receiver[i]]; // 남은 만큼 빼줘.
					next[receiver[i]] = now[receiver[i]]; //최대로 채워.
				}
				
				if(!visited[next[0]][next[1]]) {
					visited[next[0]][next[1]] = true;
					q.offer(new AB(next[0],next[1]));
					if(next[0] == 0) {
						answer[next[2]] = true;
					}
				}
			}
			
			
			
		}
	}
	
}
