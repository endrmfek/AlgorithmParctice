package programmers;

import java.util.ArrayList;
import java.util.List;

public class 최소직사각형 {
	public int solution(int[][] sizes) {
        int answer = 0;
        List<Integer> maxList= new ArrayList<>();
        List<Integer> minList= new ArrayList<>();
        
        for(int[] size : sizes) {
        	int max = Math.max(size[0], size[1]);
        	int min = Math.min(size[0], size[1]);
        	maxList.add(max);
        	minList.add(min);
        }
        
        int max = maxList.stream().mapToInt(i->i).max().getAsInt();
        int min = minList.stream().mapToInt(i->i).max().getAsInt();
        
        
        return max*min;
    }
}
