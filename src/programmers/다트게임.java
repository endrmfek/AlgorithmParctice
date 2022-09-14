package programmers;

import java.util.Deque;
import java.util.LinkedList;

public class 다트게임 {
	public int solution(String dartResult) {
        //3번만 쏠수있어.
        //0~10점
        //S , D , T -> 1,2,3제곱
        //*, # -> 해당점수와바로전점수를 각 2배 , #은 마이너스
        //* 첫번째나오면 첫점수만 2배
        //* 중첩은 4배
        //* # 중첩시 -2배
        //* # 존재하지 않을수도
        char[] darts = dartResult.toCharArray();
        int[] score = new int[3];
        int cnt = -1;
        
        for(int i=0; i<darts.length; i++) {
        	if(darts[i] >='0' && darts[i] <= '9') { 
        		cnt++;
        		if(darts[i] =='1' && darts[i+1]=='0') {
        			score[cnt] = 10;
        			i++;
        		} else {
        			score[cnt] = darts[i] -'0';
        		}
        	}
        	else if (darts[i] == 'D') {
        		score[cnt] *= score[cnt];
        	}
        	else if (darts[i] == 'T') {
        		score[cnt] *= score[cnt] * score[cnt];
        	}
        	else if (darts[i] == '*') {
        		if (cnt >0) {
        			score[cnt-1] *= 2;
        		}
        		score[cnt] *= 2;
        	} else if (darts[i] == '#') {
        		score[cnt] *= -1;
        	}
        }
        return score[0] +score[1] + score[2];
    }
}
