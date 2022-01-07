package gridy;

import java.util.*;

// 숫자로만 이뤄진 문자열이 주어졌을때 각 자리수 사이에 x , +를 넣어 제일 큰 수를 만들어볼래?

// 너 문자열에 들어있는 문자 어떻게 숫자로 바꿀거야?
// 문자열을 문자단위로 쪼갤수있어?

public class MulOrAdd {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		String data = sc.nextLine();
		
		int result =0; // 결과값.
		
		
		for(int i=0; i<data.length(); i++) {
			int temp = data.charAt(i) - '0';
			if(temp == 0 || temp ==1 || result ==0) {
				result += temp;
			} else {
				result = result * temp;
			}
		}
		
		System.out.println(result);
	}
}
