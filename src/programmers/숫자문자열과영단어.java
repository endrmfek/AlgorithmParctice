package programmers;

public class 숫자문자열과영단어 {
	public int solution(String s) {
        int answer = 0;
        String[] data = {"zero", "one", "two", "three","four","five","six","seven","eight","nine" };
        
        for (int i=0; i<data.length; i++) {
        	if (s.contains(data[i])) {
        		s = s.replaceAll(data[i], String.valueOf(i));
        	}
        }
        return Integer.parseInt(s);
    }
}
