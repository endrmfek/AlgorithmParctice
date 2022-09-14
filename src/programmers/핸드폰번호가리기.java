package programmers;

public class 핸드폰번호가리기 {
	public String solution(String phone_number) { // 11
        String answer = "";
        int n = phone_number.length();
        String prefix = phone_number.substring(0,n-4); // 0~6
        prefix = prefix.replaceAll("[0-9]", "*");
        String postfix = phone_number.substring(n-4); //
        return prefix +postfix;
    }
}
