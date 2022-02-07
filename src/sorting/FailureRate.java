package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어의 수

class Node_Fail implements Comparable<Node_Fail>{
	private int stage;
	private double fail;
	
	public Node_Fail(int stage, double fail) {
		this.stage = stage;
		this.fail = fail;
	}
	
	public int getStage() {
		return stage;
	}
	public double getFail() {
		return fail;
	}
	
	@Override
	public int compareTo(Node_Fail other) {
		if(this.fail == other.fail) {
			return this.stage - other.stage;
		}
		return Double.compare(other.fail, this.fail);
	}
	
}


public class FailureRate {
	
	public static int[] solution(int N, int[] stages) { //스테이지 개수, 스테이지 번호
		int[] answer = new int[N];
		ArrayList<Node_Fail> data = new ArrayList<>();
		int length = stages.length;
		
		for(int i=1; i<N; i++) {
			int cnt =0;
			for(int j=0; j<stages.length; j++) {
				if(stages[j] == i) {
					cnt += 1;
				}
			}
			
			double fail =0;
			if(cnt >= 1) {
				fail = (double) cnt / length;
			}
			
			data.add(new Node_Fail(i, fail));
			length -= cnt;
		}
		
		Collections.sort(data);
		
		for(int i=0; i<N; i++) {
			answer[i] = data.get(i).getStage();
		}
		
		return answer;
	}
}
