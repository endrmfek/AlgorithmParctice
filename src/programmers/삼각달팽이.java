package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 삼각달팽이 {
	public List<Integer> solution(int n) { // 아래 옆 대각선 규칙.
        List<Integer> list = new ArrayList<>();
        int[][] data = new int[n][n];
        int x= -1, y=0, idx=1;
        
        for(int i=0; i<n; i++) {
        	for(int j=i; j<n; j++) {
        		if( i%3 == 0) { //아래로
        			x++;
        		}else if(i%3 == 1) { // 오른족으로
        			y++;
        		}else {
        			x--;
        			y--; // 대각선
        		}
        		data[x][y] = idx++;
        	}
        }
        System.out.println(Arrays.toString(data[0]));
        for(int i=0; i<n; i++) {
        	for(int j=0; j<=i; j++) {
        		list.add(data[i][j]);
        	}
        }
        return list;
    }
}
