
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Long Min = sc.nextLong();
		Long Max = sc.nextLong();
		
		long[] number = new long[10000001];
		
		for(int i=2; i<10000001; i++) {
			number[i] = i;
			
		}
		
		for(int i=2; i<=Math.sqrt(number.length); i++) { //에라토스테네스
			if(number[i] == 0) continue;
			
			for(int j=i+i; j<number.length; j=j+i) { //배수 지우기
				number[j] = 0;
			}
		}
		
		int count =0;
		for(int i=2; i<10000001; i++) {
			if(number[i] != 0) {
				long temp = number[i];
				while( (double)number[i] <= (double)Max/(double)temp ) { //number^2 <= max == number <= max/number
					if((double)number[i] >= (double)Min/(double)temp) { //number^2 >= min == number <= min/number
						count++;
					}
					temp = temp * number[i];
				}
			}
		}
		System.out.println(count);
	}
}
