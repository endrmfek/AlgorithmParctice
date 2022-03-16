package string;

public class convertBase { 
	// 문자열 S가 입력으로 들어올때 밑수가 b1인 문자열 S를 b2인 문자열로 바꿔라.
	// 10진수로 바꾼다음에 b2진수로 바꾸자.
	// 재귀를 써봐
	
	public static String convertBase(String numAsString, int b1, int b2) { //이거 존나 신기하네..
		boolean isNegative = numAsString.startsWith("-");
		int numAsInt = 0;
		for(int i= (isNegative ? 1 : 0); i<numAsString.length(); i++) {
			numAsInt *= b1; // 자릿수.
			numAsInt += Character.isDigit(numAsString.charAt(i)) // 10진수면
					? numAsString.charAt(i) - '0' // 그냥 숫자로 변환
					: numAsString.charAt(i) - 'A' + 10; // ex A = 10 , B = 11
			System.out.println(numAsInt);
		};
		return  (isNegative ? "-" : "") + (numAsInt == 0 ? "0" : constructFromBase(numAsInt, b2));
	}

	private static String constructFromBase(int numAsInt, int base) { // 10진수 -> base 진수로 바꾸는 나누셈 생각해바. 재귀 = 스택
		System.out.println(numAsInt);
		return numAsInt == 0
				? ""
				: constructFromBase(numAsInt / base , base) + (char)(numAsInt % base >= 10 			//몫 , 나머지.
																	? 'A' + numAsInt % base - 10 
																	: '0' + numAsInt % base);
	}
	
	public static void main(String[] args) {
		System.out.println(convertBase("615", 7, 13));
	}

}
