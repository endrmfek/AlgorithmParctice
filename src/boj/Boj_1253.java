package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1253 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long data[] = new long[N];
		
		for(int i=0; i<N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(data);
		
		for(int k=0; k<N; k++) {
			long find = data[k];
			int i=0;
			int j=N-1;
			
			while(i<j) {
				if(data[i] + data[j] == find) { //같지만 i,j에 data가 포함되면 안됨.
					
					if(i != k && j != k) {
						result++;
						break;
					} else if( i==k) {
						i++;
					} else if( j==k) {
						j--;
					}
					
				} else if(data[i] + data[j] < find) {
					i++;
				} else { //data[i] + data[j] > find
					j--;
				}
			}
		}
		System.out.println(result);
	}
}
