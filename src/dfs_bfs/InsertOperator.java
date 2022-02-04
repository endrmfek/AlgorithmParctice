package dfs_bfs;

import java.util.ArrayList;
import java.util.Scanner;

public class InsertOperator {
	public static int n;
	public static ArrayList<Integer> arr = new ArrayList<>();
	public static int add, sub, mul, div;
	public static int maxV = (int) -1e9;
	public static int minV = (int) 1e9;
	
	public static void dfs(int i , int now) {
		if(i==n) {
			minV = Math.min(minV, now);
			maxV = Math.max(maxV, now);
		} 
		else {
			if( add >0) {
				add -=1;
				dfs(i+1, now + arr.get(i));
				add +=1;
			}
			if( sub >0) {
				sub -=1;
				dfs(i+1, now - arr.get(i));
				sub +=1;
			}
			if( mul >0) {
				mul -=1;
				dfs(i+1, now * arr.get(i));
				mul +=1;
			}
			if( div >0) {
				div -=1;
				dfs(i+1, now / arr.get(i));
				div +=1;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			int num = sc.nextInt();
			arr.add(num);
		}
		
		add = sc.nextInt();
		sub = sc.nextInt();
		mul = sc.nextInt();
		div = sc.nextInt();
		
		dfs(1,arr.get(0));
		
		System.out.println(maxV);
		System.out.println(minV);
	}
}
