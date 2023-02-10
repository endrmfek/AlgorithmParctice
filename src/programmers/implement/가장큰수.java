package programmers.implement;

import java.util.Arrays;
import java.util.Comparator;

public class 가장큰수 {
    public static String solution(int[] numbers) {
        String a = "";

        String[] arr = new String[numbers.length];
        for(int i=0; i<numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        //사전 역순으로 정렬해.
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        if(arr[0].equals("0")) return "0";

        return String.join("" , arr);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 30, 34, 5, 9}));
    }
}
