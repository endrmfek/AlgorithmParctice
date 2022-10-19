package boj;

import java.util.ArrayList;
import java.util.Arrays;

public class ps1 {
	public static int solution(int[] arr) {
        int answer = 0;
        ArrayList<String> result = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++) {
        	char[] number = Integer.toString(arr[i]).toCharArray();
        	Arrays.sort(number);
        	String number1 = String.valueOf(number);
        	
    		if(!result.contains(number1)) {
    				result.add(number1);
    			}
    		}
	    
        return result.size();
    }
	public static void main(String[] args) {
		solution(new int[] {112,1814,121,1481,1184});
	}
}
