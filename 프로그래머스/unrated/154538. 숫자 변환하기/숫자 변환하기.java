import java.util.*;
class Solution {
     public int solution(int x, int y, int n) {
        int cnt = 0;
		Queue<Integer> q = new LinkedList<>();
		Set<Integer> hs = new HashSet<>();
		q.offer(x);
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0 ; i<size ; i++) {
				if(q.peek()==y) {
					return cnt;
				}
				helper(q.poll(), y, n, hs, q);
			}
			cnt++;
		}
		return -1;
    }
	
	public static void helper(int num, int y, int n, Set<Integer> hs, Queue<Integer> q) {
		if(num+n <= y && !hs.contains(num+n)) {
			hs.add(num+n);
			q.offer(num+n);
		}
		if(num*2 <= y && !hs.contains(num*2)) {
			hs.add(num*2);
			q.offer(num*2);
		}
		if(num*3 <= y && !hs.contains(num*3)) {
			hs.add(num*3);
			q.offer(num*3);
		}
		return;
	}

}