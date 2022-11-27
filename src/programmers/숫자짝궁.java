package programmers;

import java.util.Arrays;

public class 숫자짝궁 {
    public String solution(String X, String Y) {

        StringBuilder sb = new StringBuilder();

        int[] arrX = new int[10];
        int[] arrY = new int[10];

        countNumber(X, arrX);
        countNumber(Y, arrY);
        System.out.println(Arrays.toString(arrY));
        for(int i=arrX.length-1; i>=0; i--) {
            while(arrX[i] >= 1 && arrY[i] >= 1) {
                arrX[i]--;
                arrY[i]--;
                sb.append(i);
            }
        }

        if(sb.toString().equals("")) return "-1";
        else if(sb.toString().startsWith("0")) return "0";
        else return sb.toString();
    }

    void countNumber(String num , int[] arr) {
        for(int i=0; i<num.length(); i++) {
            int number = Character.getNumericValue(num.charAt(i));
            System.out.print(number);
            arr[number]++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        숫자짝궁 a = new 숫자짝궁();
        System.out.println(a.solution("100", "203045"));
    }
}
