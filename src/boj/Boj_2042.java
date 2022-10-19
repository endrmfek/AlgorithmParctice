package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2042 {
	static long[] tree;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 개수
		int M = Integer.parseInt(st.nextToken()); // 변경
		int K = Integer.parseInt(st.nextToken()); // 구간 합
		
		int treeHight = 0;
		int length = N; // 문제서는 5.
		
		while(length != 0) {
			length /= 2; // 2 , 1, 0
			treeHight++; // 3.
		}
		
		int treeSize = (int) Math.pow(2, treeHight+1); // 2^treeHight * 2 // 16?
		int startIndex = treeSize/2 -1;
		System.out.println(startIndex);
		tree = new long[treeSize + 1];
		
		for(int i=startIndex+1; i<=startIndex + N; i++) {
			tree[i] = Long.parseLong(br.readLine());
		}
		setTree(treeSize-1);
		
		for(int i=0; i<M+K; i++) {
			st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			long e = Long.parseLong(st.nextToken());
			
			if(a==1) {
				changeVal(startIndex+s , e);
			} else if (a == 2) {
				s = s+ startIndex;
				e = e+ startIndex;
				System.out.println(getSum(s , (int) e));
			} else {
				return;
			}
		}
		br.close();
	}
	
	private static void setTree(int i) {
		while(i != 1) {
			tree[i/2] += tree[i];
			i--;
		}
	}
	
	private static void changeVal(int index, long val) {
		long diff = val - tree[index];
		while(index > 0) {
			tree[index] = tree[index] + diff;
			index = index /2;
		}
	}
	
	private static long getSum(int s , int e) {
		long partSum = 0;
		while(s <= e) {
			if(s%2 == 1) {
				partSum = partSum + tree[s];
				s++;
			}
			if(e%2 == 0) {
				partSum = partSum + tree[e];
				e--;
			}
			s = s/2;
			e = e/2;
		}
		return partSum;
	}
}
