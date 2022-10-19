package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_13251 {
	//다 수학적으로 풀어보리네
	public static void main(String[] args) throws IOException {
		int M, K, totalStoneNumber;
		int[] kindOfStone = new int[51];
		double[] probability = new double[51];
		double answer;
		totalStoneNumber = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) { //M개
			kindOfStone[i] = Integer.parseInt(st.nextToken());
			totalStoneNumber += kindOfStone[i]; 
		}
		st= new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		answer = 0.0;
		
		for(int i=0; i<M; i++) {
			if(kindOfStone[i] >= K) {
				probability[i] = 1.0;
				for(int k=0; k<K; k++) { //0~K까지 돌면서
					probability[i] *= (double) (kindOfStone[i] - k) / (totalStoneNumber - k); //중복해서 뽑을 확률
				}
			}
			answer+= probability[i];
		}
		System.out.println(answer);
	}
}
