import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		public int index;
		public int value;
		
		public Node(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		Deque<Node> deq = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			int now = Integer.parseInt(st.nextToken());
			
			while(!deq.isEmpty() && deq.getLast().value > now) {
				deq.removeLast();
			}
			
			deq.addLast(new Node(i, now));
			
			if(deq.getFirst().index <= i-L) {
				deq.removeFirst();
			}
			sb.append(deq.getFirst().value).append(' ');
//			System.out.print(deq.getFirst().value + " ");
			
			
		}
		
		br.close();
		System.out.println(sb.toString());
	}
	
}
