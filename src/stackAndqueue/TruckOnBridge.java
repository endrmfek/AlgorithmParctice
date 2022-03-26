package stackAndqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

public class TruckOnBridge {
	
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<Integer> bridge = new LinkedList<>();
		int time = 0;
		int sum = 0;
		
		for(int i=0; i<truck_weights.length; i++) { //각 대수마다
			
			int truck = truck_weights[i];
			
			while(true) {
				if(bridge.isEmpty()) { //다리가 비어있어?
					//트럭을 넣어야돼.
					bridge.offer(truck);
					time++;
					sum += truck;
					break;
				} else if(bridge.size() == bridge_length) { //트럭이 다찻을때
					sum -= bridge.poll();
				} else { //다리가 비어있지 않은데 들어갈 자리가 있을때
					if(sum + truck <= weight) {
						bridge.offer(truck);
						sum += truck;
						time++;
						break;
					} else { //들어갈 자리는 있는데 무게가 안될때
						bridge.offer(0);
						time++;
					}
					
				}
			}
			
		}
		
        return time + bridge_length; //마지막에 올라가자마자 끝나버림.
    }
	
}
