package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_13398 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n =Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dpL = new int[n]; // 왼쪽에서 오른쪽으로가는 연속합.
		dpL[0] = arr[0];
		int result = arr[0];
		
		for(int i=1; i<n; i++) {
			dpL[i] = Math.max(dpL[i-1] + arr[i], arr[i]); //연속합 구하기.
			result = Math.max(result, dpL[i]); //1개도 제거하지 않았을때.
		}
	
		int[] dpR = new int[n];
		dpR[n-1] = arr[n-1]; // 오른쪽에서 왼쪽으로가는 연속합
		for(int i=n-2; i>=0; i--) {
			dpR[i] = Math.max(dpR[i+1] + arr[i],  arr[i]);
		}
		
		// n번째 숫자를 뺐을때 L[n-1] + R[n+1]는 최대값이지.
		for(int i=1; i<n-1; i++) { //맨 앞과 맨 뒤는 제외하고빼야지.
			int temp = dpL[i-1] + dpR[i+1];
			result = Math.max(result, temp);
		}
		
		System.out.println(result);
	}
}
