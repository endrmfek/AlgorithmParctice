package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10868 {
	static long[] tree;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int treeHeight = 0;
		int length = N; 
		while(length != 0) {
			length /= 2;
			treeHeight++;
		}
		int treeSize =(int) Math.pow(2, treeHeight + 1);
		int startIndex = treeSize /2 -1;
		tree = new long[treeSize+1];
		
		for(int i=0; i<tree.length; i++) {
			tree[i] = Integer.MAX_VALUE;
		}
		
		for(int i=startIndex+1; i<=startIndex+N; i++) {
			tree[i] = Long.parseLong(br.readLine());
		}
		
		setTree(treeSize-1); //사이즈랑 인덱스랑 1차이나는거 기억해라.
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			s = s + startIndex;
			e = e + startIndex;
			System.out.println(getMin(s, e));
		}
		br.close();		
	}
	
	private static void setTree(int i) {
		while(i != 1) {
			if(tree[i/2] > tree[i]) { // Math.min안써도되네?
				tree[i/2] = tree[i];
			}
			i--;
		}
	}
	
	private static long getMin(int s, int e) {
		long min = Integer.MAX_VALUE;
		while( s <= e) {
			if(s%2 ==  1) {
				min = Math.min(min, tree[s]);
				s++;
			}
			s = s/2;
			if(e%2 == 0) {
				min = Math.min(min, tree[e]);
				e--;
			}
			e = e/2;
		}
		return min;
	}
}
