package programmers;

public class 최대공약수최소공배수 {
	public int[] solution(int n, int m) {
        int[] answer = {};
        int greatest = 0;
        if (n > m) {
        	greatest = gcd(n,m);
        } else {
        	greatest = gcd(m,n);
        }
        
        return new int[] {greatest , (n*m) / greatest};
    }
	
	public int gcd(int a, int b ) {
		if( a % b == 0) {
			return b;
		}
		return gcd(b, a%b);
	}
}
