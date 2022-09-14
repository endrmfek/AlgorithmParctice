package programmers;

public class 약수의개수와덧셈 {
	public static int solution(int left, int right) {
        int answer = 0;
        for(int i=left; i<=right; i++) {
        	int check = check(i);
        	System.out.println(check);
        	answer += check;
        }
        return answer;
    }
	
	public static int check(int num) {
		int pow = (int) (num/2)+1;
		int count = 1;
		for(int i=1; i<pow; i++) {
			if ((num % i) == 0) {
				count++;
			}
		}
		if (count%2 == 0) {
			return num;
		}
		else {
			return -num;
		}
	}
	
	public static void main(String[] args) {
		solution(13, 17);
	}
}
