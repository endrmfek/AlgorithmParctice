package boj;

import java.util.Arrays;

public class ps2 {
	
	    public static int solution(int[] players) {
	        int answer = -1;
	        int length = players.length;
	        int[] temp = players.clone();
	        int count = 0;
	        int max = -1;
	        int number1 = 1;
	        while(length != 1) {
	        	int index = 0;
	        	System.out.println(Arrays.toString(temp));
	        	for(int i=0; i<length; i=i+2) {
	        		boolean special = false;
	        		if (temp[i]==1 || temp[i+1]==1) {
	        			special = true;
	        		} else if(temp[i]==0 && temp[i+1]==0){
	        			if(number1 == 1) {
	        				special = true;
	        				number1 -=1;
	        			}
	        		}
	        		
	        		if(special) {
	        			System.out.println(i);
	        			count +=1;
	        			temp[index]=1;
	        			index++;
	        		} else {
	        			temp[index]=0;
	        			index++;
	        		}
	        		
	        	}
	        	length = length/2;
	        }
	        
	        max = Math.max(max, count);
	        return count;
	    }
	    public static void main(String[] args) {
			solution(new int[] {0,0,0,1});
		}
}
