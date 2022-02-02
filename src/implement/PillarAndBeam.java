package implement;

import java.util.ArrayList;
import java.util.Collections;

class Node implements Comparable<Node> {
	private int x;
	private int y;
	private int stuff;
	
	public Node(int x, int y, int stuff) {
		this.x = x;
		this.y = y;
		this.stuff = stuff;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y; 
	}
	
	public int getStuff() {
		return stuff;
	}
	
	
	@Override
	public int compareTo(Node o) {
		if( (this.x-o.x)==0 && (this.y-o.y) ==0) {
			return Integer.compare(this.stuff, o.stuff);
		}
		
		if(this.x == o.x) {
			return Integer.compare(this.y, o.y);
		}
		return this.x-o.x;
	}

}

public class PillarAndBeam {
	
	public boolean possible(ArrayList<ArrayList<Integer>> answer) {
		for(int i=0; i<answer.size(); i++) {
			int x = answer.get(i).get(0);
			int y = answer.get(i).get(i);
			int stuff = answer.get(i).get(2);
			
			if(stuff == 0) { //기둥일때
				boolean check = false;
				if( y==0 ) check = true;
				
				for(int j=0; j<answer.size(); j++) {
					if (x - 1 == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2)) {
						check = true;
					}
					
					if (x == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2)) {
                        check = true;
                    }
					
					if (x == answer.get(j).get(0) && y - 1 == answer.get(j).get(1) && 0 == answer.get(j).get(2)) {
						check = true;
					}
				}
				if(!check) return false;
			}
			
			else if(stuff == 1) { // 보 인경우
				boolean check = false;
				boolean right = false;
				boolean left = false;
				
				//기둥 위, 다른보와 연결
				for(int j=0; j < answer.size(); j++) {
					if (x == answer.get(j).get(0) && y - 1 == answer.get(j).get(1) && 0 == answer.get(j).get(2)) {
                        check = true;
                    }
					
					if (x + 1 == answer.get(j).get(0) && y - 1 == answer.get(j).get(1) && 0 == answer.get(j).get(2)) {
                        check = true;
                    }
					
					if (x - 1 == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2)) {
                        left = true;
                    }
					
					if (x + 1 == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2)) {
                        right = true;
                    }
				}
				if(left && right) check = true;
				if(!check) return false;
				
				
			}
			
		}
		return true;
	}
	
	public int[][] solution (int n, int[][] build_frame) {
		ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0; i<build_frame.length; i++) {
			int x= build_frame[i][0];
			int y= build_frame[i][1];
			int stuff = build_frame[i][2];
			int operate = build_frame[i][3];
			
			if(operate == 0) { //삭제하는 경우
				int index =0;
				for(int j=0; j<answer.size(); j++) {
					if(x == answer.get(j).get(0) && y == answer.get(j).get(1) && stuff == answer.get(j).get(2)) {
						index = j;
					}
				}
				
				ArrayList<Integer> erased = answer.get(index);
				answer.remove(index); //삭제를 해보고
				if(!possible(answer)) { //아니라면 다시 설치
					answer.add(erased);
				}
				
				if(operate == 1) {
					ArrayList<Integer> inserted = new ArrayList<>();
					inserted.add(x);
					inserted.add(y);
					inserted.add(stuff);
					answer.add(inserted);
					if(!possible(answer)) {
						answer.remove(answer.size() -1);
					}
				}
						
			}
			
		}

		ArrayList<Node> ans = new ArrayList<Node>();
		for(int i=0; i<answer.size(); i++) {
			ans.add(new Node(answer.get(i).get(0),answer.get(i).get(1),answer.get(i).get(2)));		
		}
		Collections.sort(ans);
		
		int[][] res = new int[ans.size()][3];
		for(int i=0; i<ans.size(); i++) {
			res[i][0] = ans.get(i).getX();
			res[i][1] = ans.get(i).getY();
			res[i][2] = ans.get(i).getStuff();
		}
		return res;
	}
}
