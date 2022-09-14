package programmers;

public class 삼진법뒤집기 {
	public static int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        
        while ( n != 0 ) {
        	int remainder = n%3;
        	sb.append(remainder);
        	n = (int) n/3;
        }
        
        return Integer.valueOf(sb.toString(), 3);
    }
	
	public static void main(String[] args) {
		System.out.println(solution(125));
	}
}
