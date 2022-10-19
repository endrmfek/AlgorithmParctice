package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11505 {
	static long[] tree;
	static int MOD = 1000000007;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int treeHeight = 0;
		int length = N;
		while(length != 0) {
			length /= 2;
			treeHeight++;
		}
		
		int treeSize = (int) Math.pow(2, treeHeight+1);
		tree = new long[treeSize + 1];
		int startIndex = treeSize /2 -1;
		
		for(int i=0; i<treeSize; i++) {
			tree[i] = 1;
		}
		
		for(int i=startIndex+1; i<=startIndex+N; i++) {
			tree[i] = Long.parseLong(br.readLine());
		}
		
		setTree(treeSize - 1);
		
		for(int i=0; i<M+K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			long e = Long.parseLong(st.nextToken());
			
			if (a == 1) {
				changeVal(startIndex + s , e);
			} else if (a == 2){
				s = s + startIndex;
				e = e + startIndex;
				System.out.println(getMul(s, (int) e));
			} else {
				return;
			}
			
		}
		br.close();
	}
	
	private static void setTree(int i) {
		while(i != 1) {
			tree[i/2] = tree[i/2] * tree[i] %MOD;
			i--;
		}
	}
	private static void changeVal(int index , long value) {
		tree[index] = value;
		while(index > 1) {
			index = index / 2;
			tree[index] = tree[index * 2] % MOD *tree[index*2 + 1] % MOD; 
		}
	}
	
	private static long getMul(int s , int e) {
		long partMul = 1;
		while( s <= e) {
			if (s %2 == 1) {
				partMul = partMul * tree[s] % MOD;
				s++;
			}
			s = s/2;
			if(e % 2 == 0) {
				partMul = partMul * tree[e] % MOD;
				e--;
			}
			e = e/2;
		}
		return partMul;
	}
}
