package implement;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationEx {
	private int n; // n C r
	private int r;
	private int[] now;
	private ArrayList<ArrayList<Integer>> result;
	
	public ArrayList<ArrayList<Integer>> getResult() {
		return result;
	}
	
	public CombinationEx(int n , int r) {
		this.n = n;
		this.r = r;
		this.now = new int[r]; // 5 C 3 -> [1,2,3]
		this.result = new ArrayList<ArrayList<Integer>>();
	}
	
	public void combination(ArrayList<Integer> arr ,int depth, int index, int target ) {
		System.out.println("초기 arr" + arr );
		System.out.println("depth , index, target : " + depth+ " " + index+ " " + target);
		if(depth == r) {
			ArrayList<Integer> temp = new ArrayList<>();
			for(int i=0; i<now.length; i++) {
				temp.add(arr.get(now[i]));
				System.out.println("temp : " + temp);
			}
			result.add(temp);
			System.out.println("====================");
			return;
		}
		if(target == n) return;
		now[index] = target;
		System.out.println("now[index]: " + now[0] + now[1] + now[2] );
		combination(arr,depth+1, index+1, target+1);
		combination(arr,depth,index,target+1);
	}
	
	public static void main(String[] args) {
		CombinationEx ex = new CombinationEx(5, 3);
		ex.combination(new ArrayList<>(Arrays.asList(1,2,3,4,5)) , 0, 0, 0);
		System.out.println(ex.getResult());
	}
}
