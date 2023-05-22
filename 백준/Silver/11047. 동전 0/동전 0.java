import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Integer[] coin = new Integer[n];
		
		for(int i=0; i<n; i++) {
			int c = Integer.parseInt(br.readLine());
			coin[i] = c;
		}
		
		Arrays.sort(coin, Collections.reverseOrder());
		int result = 0;
		for(int i=0; i<n; i++) {
			if(coin[i] > k) continue;
			
			result += k / coin[i];
			k = k % coin[i];
		}
		
		System.out.println(result);
	}
}
