package implement;

import java.util.ArrayList;
import java.util.Scanner;

class Combination {
	private int n;
	private int r;
	private int[] now; //현재 조합
	private ArrayList<ArrayList<Position_c>> result; // 조합 결과
	
	public ArrayList<ArrayList<Position_c>> getResult() {
		return result;
	}
	
	public Combination(int n, int r) {
		this.n = n;
		this.r = r;
		this.now = new int[r];
		this.result = new ArrayList<ArrayList<Position_c>>();
		
	}
	
	public void combination(ArrayList<Position_c> arr, int depth, int index, int target) {
		if( depth == r) {
			ArrayList<Position_c> temp = new ArrayList<>();
			for(int i=0; i<now.length; i++) {
				temp.add(arr.get(now[i]));
			}
			result.add(temp);
			return;
		}
		if( target == n) return;
		now[index] = target;
		combination(arr, depth +1, index+1, target+1);
		combination(arr, depth, index, target+1);
	}
}

class Position_c {
	private int x;
	private int y;
	
	public Position_c(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
}

public class ChickenDelivery {
	public static int n,m;
	public static int[][] arr = new int[50][50];
	public static ArrayList<Position_c> chicken = new ArrayList<>(); //치킨집 위치
	public static ArrayList<Position_c> house = new ArrayList<>(); //하우스 위치
	
	public static int getSum(ArrayList<Position_c> candidate) {
		
		int result = 0;
		
		for(int i=0; i<house.size(); i++) {
			int hx = house.get(i).getX();
			int hy = house.get(i).getY();
			
			int temp = (int) 1e9;
			for(int j=0; j<candidate.size(); j++) {
				int cx = candidate.get(j).getX();
				int cy = candidate.get(j).getY();
				
				temp = Math.min(temp, Math.abs(hx-cx) + Math.abs(hx-cy));
			}
			
			result += temp;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				arr[r][c] = sc.nextInt();
				if(arr[r][c] == 1) {
					house.add(new Position_c(r, c));
				}
				if(arr[r][c] == 2) {
					chicken.add(new Position_c(r,c));
				}
			}
		}
		
		Combination combi = new Combination(chicken.size(), m);
		combi.combination(chicken, 0, 0, 0);
		ArrayList<ArrayList<Position_c>> chickenList = combi.getResult();
		
		int result = (int) 1e9;
		for(int i=0; i<chickenList.size(); i++) {
			result = Math.min(result, getSum(chickenList.get(i)));
		}
	}

	
}
