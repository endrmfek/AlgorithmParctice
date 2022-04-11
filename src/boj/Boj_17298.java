package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_17298 { // 인덱스를 스택에 넣어 활용하기
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] data = new int[n];
		int[] result = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> stack = new Stack<>();
		stack.push(0); // 인덱스를 넣어야됨.
		
		for(int i=1; i<n; i++) {
			while(!stack.isEmpty() && data[stack.peek()] < data[i]) {
				result[stack.pop()] = data[i]; 
			}
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			result[stack.pop()] = -1;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb.toString());
		
	}
}
