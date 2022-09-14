package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 문자열내림차순 {
	public String solution(String s) {
        String answer = "";
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder(new String(arr));
        
        Stream.of(s.split("")).sorted(Collections.reverseOrder()).collect(Collectors.joining());
        return sb.reverse().toString();
    }
}
