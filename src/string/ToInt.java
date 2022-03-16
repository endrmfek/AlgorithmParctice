package string;

public class ToInt {
	//parseInt를 쓰지않고 정수형으로 바꿀수 있을까?
	//각 자리수를 구하는게 중요하겠져?
	//여기서 1의 자리수 값은 x mod 10
	//나머지 자리는 x / 10 으로 구할 수있다.
	//ex 423 -> 423 mod 10 -> 3 , 42 / 10 -> 4 나머지 2
	
	public static String intToString(int x) {
		boolean isNegative = false;
		if( x<0) { // 음수 체크
			isNegative = true;
		}
		
		StringBuilder s = new StringBuilder();
		do {
			s.append((char)('0' + Math.abs( x % 10 ))); // 이거 잘 알아놔라. '0'의 아스키값 = 48.
			x /= 10;
		} while(x != 0 );
		
		if(isNegative) {
			s.append('-');
		}
		s.reverse();
		return s.toString();
	}
	
	public static int stringToInt(String s) {
		int result = 0; // 자리수
		for(int i= s.charAt(0) == '-' ? 1 : 0 ; i< s.length(); i++) {
			final int digit = s.charAt(i) - '0';
			result = result*10 + digit;
		}
		return s.charAt(0) == '-' ? -result : result;
	}
	
	public static void main(String[] args) {
		System.out.println(intToString(423));
	}
}
