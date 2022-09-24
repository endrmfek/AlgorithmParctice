import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		int N, Q;
		long factorial[] = new long[21];
		int s[] = new int[21];
		boolean visited[] = new boolean[21];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Q = Integer.parseInt(st.nextToken());
		factorial[0] = 1;
		for(int i=1; i<=N; i++) {
			factorial[i] = factorial[i-1] * i;
		}
		
		if(Q==1) { // K번째 순열 구하기 (ex 1 3 2 4)
			long k = Long.parseLong(st.nextToken());
			for(int i=1; i<=N; i++) {	//각 자리수에 대해 i = 3이면
				for(int j=1, cnt =1; j<=N; j++) { //1부터 각 자리수가 가진 숫자까지 j= 2일때
					if(visited[j]) continue;	
					
					if(k <= cnt * factorial[N-i]) {	// cnt = 1, factorial[0] ? k = 1 <= 1* fact[1]
						k -= ((cnt-1)*factorial[N-i]); // k= 1
						s[i] = j;
						visited[j] = true;
						break;
					}
					cnt++;
				}
			}
			for(int i=1; i<=N; i++) {
				System.out.print(s[i] + " ");
			}
		} else { //주어진놈 몇번째 순열이냐
			long k = 1;
			for(int i=1; i<=N; i++) {
				s[i] = Integer.parseInt(st.nextToken());
				long cnt =0;
				for(int j=1; j<s[i]; j++) {
					if(visited[j] == false) {
						cnt ++;
					}
				}
				k += cnt * factorial[N-i];
				visited[s[i]] = true;
			}
			System.out.println(k);
		}
	} 
}
