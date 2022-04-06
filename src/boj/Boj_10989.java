package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_10989 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] count = new int[10001];
		int N = Integer.parseInt(br.readLine());
		
		// ver1
		
//		int[] data = new int[N];
//		for(int i=0; i<N; i++) {
//			data[i] = Integer.parseInt(br.readLine());
//		}
//		
//		Arrays.sort(data);
//		for(int i=0; i<N; i++) {
//			sb.append(data[i]).append('\n');
//		}
		
		
		// ver2
		
		for(int i=0; i<N; i++) {
			count[Integer.parseInt(br.readLine())]++;
		}
		
		br.close();
		
		for(int i=0; i<10001; i++) {
			while(count[i] > 0) {
				sb.append(i).append('\n');
				count[i]--;
			}
		}
		
		System.out.println(sb);
		
	}
}
