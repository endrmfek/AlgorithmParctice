package programmers.implement;

import baisc.Array;

import java.util.*;

public class 숫자카드나누기 {
    // 1. 최대 공약수를 구해서 해보자


    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        int minA = Arrays.stream(arrayA).min().getAsInt();
        int gcdA = getGcd(arrayA, minA);

        int minB = Arrays.stream(arrayB).min().getAsInt();
        int gcdB = getGcd(arrayB, minB);

        //A의 최대공약수가 B에 있을까?
        answer = getAnswer(gcdA, arrayB, answer);
        //B의 최대공약수가 A에 있을까?
        answer = getAnswer(gcdB, arrayA, answer);

        return answer;
    }

    int getAnswer(int gcd, int[] array, int answer) {
        for (int num : array) {
            //약수를 포함하면
            if (num % gcd == 0) {
                return Math.max(answer, 0); // 바로 0 or answer;
            }
        }
        //포함하지 않는다면 gcd , answer중 큰 수.
        return Math.max(answer, gcd);
    }

    int getGcd(int[] array, int min) {
        int gcd = 1;
        //2부터 min까지 gcd 찾기
        for (int i = 2; i <= min; i++) {
            if (isGcd(array, i)) {
                gcd = i;
            }
        }
        return gcd;
    }

    boolean isGcd(int[] array, int i) {
        for (int num : array) {
            if (num % i != 0) {
                return false;
            }
        }
        return true;
    }
}
