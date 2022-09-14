package programmers;

import java.util.Arrays;

public class 비밀지도 {
	public String[] solution(int n, int[] arr1, int[] arr2) {
        //정사각형 n , 공백 , 벽(#)
        //하나라도벽 -> 벽 , 둘다 공백 -> 공백
        //정수배열 암호화
        //벽 1 , 공백 0
        
        String[] answer = new String[n];
        
        for(int i=0; i<n; i++) { // 9 , 30 
        	String result = String.format("%16s", Integer.toBinaryString(arr1[i] | arr2[i])); //비트연산하고
        	result = result.substring(16-n); // n = 5 -> 16-5 = 11부터 16까지.
        	result = result.replace('1', '#');
        	result = result.replace('0', ' ');
        	answer[i] = result;
        }
        
        
        return answer;
    }
	public static void main(String[] args) {
		int[] arr = new int[] {9, 20, 28, 18, 11};
		String temp ="";
        for(int i=0; i<arr.length; i++) {
        	temp +="1";
        }
        String n = String.valueOf(arr.length);
//		for(int i=0; i<arr.length; i++) {
//        	arr[i] = Integer.parseInt(String.valueOf(i),2);
//        }
		System.out.println(String.format("%"+n+"s", Integer.toBinaryString(2)));
	}
}
