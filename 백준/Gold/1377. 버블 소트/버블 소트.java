
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static class Data implements Comparable<Data> {
		int index;
		int value;
		
		public Data(int index, int value) {
			this.index = index;
			this.value = value;
		}
		
		@Override
		public int compareTo(Data o) {
			// TODO Auto-generated method stub
			return this.value - o.value;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Data[] data = new Data[n];
		
		for(int i=0; i<n; i++) {
			data[i] = new Data(i, Integer.parseInt(br.readLine()));
		}
		
		Arrays.sort(data);
		
		int max = 0;
		for(int i=0; i<n; i++) {
			max = Math.max(max, data[i].index-i); // 정렬 전에서 후를 빼야져;
		}
		
		System.out.println(max+1); // 정렬 후 한번 더 훑는 경우
	}
	
}
