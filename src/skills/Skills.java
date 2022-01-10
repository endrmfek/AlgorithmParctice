package skills;

import java.util.Scanner;

public class Skills {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		// 행과 열을 한 단어로 줄때 숫자 or 영어로 변환 어떻게 할거야?
		String data1 = sc.nextLine(); // 일단 String으로 데이터를 받은 후 ex) a1
		int row = data1.charAt(0) - 'a' + 1;   // 문자 a의 아스키값이 만약 29라면 문자 a의 아스키값 29을 빼서 1로 만듬.
		int column = data1.charAt(1) - '0';    // 1
		
		
		//문자 판별하기
		Character.isLetter(data1.charAt(0));
	}
}
