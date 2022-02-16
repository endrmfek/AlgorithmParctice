package dynamic;

public class Fibo2 {
	public static long[] d = new long[1000]; // 다이나믹에서 제일 중요한 부분. d[]를 무적권만들어야됨;
	
	public static long fibo(int x) {
		if( x == 1 || x== 2) {
			return 1;
		}
		
		if(d[x] != 0) { // 이미 처리된 부분은 처리하지 않아.
			return d[x];
		}
		
		d[x] = fibo(x-1) + fibo(x-2); //점화식 그대로 (탑다운 - 보통 재귀)
		return d[x];
	}
	
	public static void main(String[] args) {
		System.out.println(fibo(50));
	}
}
