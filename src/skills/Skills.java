package skills;

import java.util.ArrayList;
import java.util.Scanner;



class Combination {  // 조합 코드
	private int n;
	private int r;
	private int[] now; //지금 조합
	private ArrayList<ArrayList<Integer>> result; // 모든 조합
	
	public ArrayList<ArrayList<Integer>> getResult() {
		return result;
	}
	
	public Combination(int n, int r) {
        this.n = n;
        this.r = r;
        this.now = new int[r];
        this.result = new ArrayList<ArrayList<Integer>>();
    }
	
	public void combination(ArrayList<Integer> arr, int depth, int index, int target) {
		if(depth == r) {
			ArrayList<Integer> temp = new ArrayList<>();
			for(int i=0; i<now.length; i++) {
				temp.add(arr.get(now[i]));
			}
			result.add(temp);
			return;
		}
		
		if(target == n) return ;
		now[index] = target;
		combination(arr, depth+1, index+1, target+1);
		combination(arr, depth, index, target+1);
	}
}

public class Skills {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		// 행과 열을 한 단어로 줄때 숫자 or 영어로 변환 어떻게 할거야?
		String data1 = sc.nextLine(); // 일단 String으로 데이터를 받은 후 ex) a1
		int row = data1.charAt(0) - 'a' + 1;   // 문자 a의 아스키값이 만약 29라면 문자 a의 아스키값 29을 빼서 1로 만듬.
		int column = data1.charAt(1) - '0';    // 1
		
		
		//문자 판별하기
		Character.isLetter(data1.charAt(0));
	}
}
