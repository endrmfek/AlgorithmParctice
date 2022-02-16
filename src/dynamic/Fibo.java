package dynamic;

public class Fibo {
	public static long[] d = new long[1000]; // 다이나믹에서 제일 중요한 부분. d[]를 무적권만들어야됨;
	
	public static void main(String[] args) {
		d[1] = 1;
		d[2] = 2;
		int n=50;
		
		for(int i=3; i<=n; i++) { // 바텀업.
			d[i] = d[i-1] + d[i-2];
		}
	}
}
