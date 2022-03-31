package exhaustiveSearch;

import java.util.ArrayList;
import java.util.Comparator;

public class Carpet {
	public ArrayList<Integer> divisor (int n) {
		
		int sqrt = (int) Math.sqrt(n);
		
		ArrayList<Integer> divisor = new ArrayList<>();
		for(int i=1; i<=sqrt; i++) {
			if(n%i == 0) {
				divisor.add(i);
				if(n/i != i) {
					divisor.add(n/i);
				}
			}
		}
		
		divisor.sort(Comparator.naturalOrder());
		return divisor;
	}
	
	
	public int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		ArrayList<Integer> divisor = divisor(yellow);
		
		for(Integer row : divisor) {
			
			int n = row + 2;
			int m = (int)(yellow / row) +2;
			
			if(n < m) continue;
			
			if((n*m) == (brown+yellow)) {
				answer[0] = n;
				answer[1] = m;
			}
		}
		
        
        return answer;
    }
	
	public static void main(String[] args) {
		Carpet c = new Carpet();
		int[] a = c.solution(8, 1);
		System.out.println(a[0] +" , "+ a[1]);
	}
}
