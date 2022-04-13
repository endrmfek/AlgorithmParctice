package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1541 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] data = input.split("-");
		
//		for(int i=0; i<data.length; i++) {
//			System.out.print(data[i] + " ");
//		}
		int result =0;
		for(int i=0; i<data.length; i++) {
			int sum = mySum(data[i]);
			if(i==0) {
				result += sum;
			} else {
				result -= sum;
			}
		}
		
		System.out.println(result);
		
	}
	
	static int mySum(String value) {
		int sum = 0;
		String[] values = value.split("\\+");
		
		for(int i=0; i<values.length; i++) {
//			System.out.print(values[i] + " ");
			sum += Integer.parseInt(values[i]);
		}
		
		return sum;
	}
}
