
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> q = new LinkedList<>();
		for(int i=1; i<n+1; i++) {
			q.addLast(i);
		}
		
		if(q.size() == 1) {
			System.out.println(q.poll());
			return;
		}
		
		while(true) {
			q.pollFirst(); //하나 버리고
			
			if(q.size() == 1) {
				break;
			}
			
			int first = q.pollFirst();
			q.addLast(first);
		}
		
		System.out.println(q.poll());
		
	}
}
