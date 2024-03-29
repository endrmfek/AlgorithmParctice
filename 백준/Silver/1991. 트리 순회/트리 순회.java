import java.util.Scanner;

public class Main {
	static int[][] tree;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine(); // 버퍼 제거
		tree = new int[26][2];
		for(int i=0; i<n; i++) {
			String[] temp = sc.nextLine().split(" ");
			int node = temp[0].charAt(0)-'A'; // index로 변환
			char left = temp[1].charAt(0);
			char right = temp[2].charAt(0);
			
			if(left == '.') {
				tree[node][0] = -1;
			}else {
				tree[node][0] = left - 'A';
			}
			if(right == '.') {
				tree[node][1] = -1;
			}else {
				tree[node][1] = right - 'A';
			}
		}	
		
		preOrder(0);
		System.out.println();
		inOrder(0);
		System.out.println();
		postOrder(0);
		System.out.println();
	
	}
	public static void preOrder(int now) { // 전위 루 왼 오
		if(now == -1) return;
		System.out.print((char) (now + 'A'));
		preOrder(tree[now][0]);
		preOrder(tree[now][1]);
	}
	
	public static void inOrder(int now) { // 중위 왼 루 오
		if(now == -1) return;
		inOrder(tree[now][0]);
		System.out.print((char) (now + 'A'));
		inOrder(tree[now][1]);
	}
	
	public static void postOrder(int now) { //후위
		if(now == -1) return;
		postOrder(tree[now][0]); //왼
		postOrder(tree[now][1]); //오
		System.out.print((char) (now + 'A'));
	}
	
}
