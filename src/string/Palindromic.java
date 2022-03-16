package string;

public class Palindromic {
	
	public static boolean isPalindromic(String s) {
		//회문 확인은 입력 문자열을 뒤집어 추가 공간을 사용해도 되지만
		//문자열을 앞뒤로 동시에 읽어서 공간을 절약하는 방법도 있다.
		
		for(int i=0, j=s.length()-1; i<j; i++, j++) { 
			if(s.charAt(i) != s.charAt(j)) {
				return false;
			}
		}
		return true;
		
	}
}
