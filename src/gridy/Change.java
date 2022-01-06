package gridy;

import java.util.Scanner;

public class Change {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int data = sc.nextInt();
		int[] change = {500,100,50,10};
		int count = 0;
		for(int c : change) {
			count = count + (int) data / c;
			data = data % c;
		}
	}
	
	
}
