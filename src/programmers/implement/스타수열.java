package programmers.implement;

public class 스타수열 {
    //2이상의 짝수
    //교집합의 원소가 1개.
    //x[n-1] != x[n]

    //스타수열의 길이.
    public int solution(int[] a) {
        int answer = -1;
        int n = a.length;
        if(n == 1) return 0;
        int[] numberList = new int[n];

        for(int number : a) {
            numberList[number]++;
        }

        for(int i=0; i<numberList.length; i++) {
            if(numberList[i] == 0) continue;
            if(numberList[i] < answer) continue;
            int temp = 0;
            for(int j=0; j<n-1; j++) {
                if(!(a[j] == i || a[j+1] == i)) continue;
                if(a[j] == a[j+1]) continue;

                temp++;
                j++;
            }
            answer = Math.max(answer, temp);
        }
        return answer * 2;
    }
}
