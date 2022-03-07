package dfs_bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Node_h {
	private int x;
	private int y;
	
	public Node_h(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	
}

public class HousingNumber_2667 {
	public static int[][] data = new int[26][26];
	public static int n;
	public static ArrayList<Integer> result = new ArrayList<>();
	public static int count = 1;
	//dfs로 했으면 한다.
	
	public static boolean dfs(int x, int y) {
		if( x<=-1 || x>=n || y<=-1 || y>=n) {
			return false;
		}
		
		if(data[x][y] == 1) {
			result.add(count);
			data[x][y] = 2;
			
			dfs(x+1,y);
			dfs(x,y-1);
			dfs(x-1,y);
			dfs(x,y+1);
			
			return true;
		}
		
		return false;		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		sc.nextLine(); // 버퍼 지우고
		
		for(int i=0; i<n; i++) {
			String str = sc.nextLine();
			for(int j=0; j<n; j++) {
				data[i][j] = str.charAt(j) - '0';
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(dfs(i,j)) {
					count+=1;
				}
			}
		}
		
		ArrayList<Integer> temp = new ArrayList<>();
		for(int i=1; i<=count; i++) {
			int temp1 = 0;
			for(int j=0; j<result.size(); j++) {
				if(result.get(j) == i) {
					temp1 +=1;
				}
			}
			temp.add(temp1);
		}
		
		Collections.sort(temp);
		System.out.println(count-1);
		for(int i=1; i<count; i++) {
			System.out.println(temp.get(i));
		}
		
	}
}
