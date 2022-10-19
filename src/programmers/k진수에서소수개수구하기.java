package programmers;

public class k진수에서소수개수구하기 {
	public static int solution(int n, int k) {
        int answer = -1;
        String result = Integer.toString(n, k);
        String[] numbers = result.split("0");
        int count = 0;
        for(String number : numbers) {
        	if(number.equals("")) continue;
        	System.out.println(number);
        	long prime = Long.parseLong(number);
        	if (isPrime(prime)) {
        		System.out.println(number);
        		count +=1;
        	}
        	
        }
        return count;
    }
	
	public static boolean isPrime(Long number) {
		if(number == 1) {
			return false;
		}
		
		if(number == 2) {
			return true;
		}
		
		for(int i=2; i<Math.sqrt(number) + 1; i++) {
			if(number % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(solution(110011, 10));
	}
}