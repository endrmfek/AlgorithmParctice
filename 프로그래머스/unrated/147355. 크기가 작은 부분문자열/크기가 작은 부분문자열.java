class Solution {
    //작거나 같은
    //p의 길이 -> 18
    //0으로시작하지 ㅇ낳아.
    public int solution(String t, String p) {
        int answer = 0;
        int pSize = p.length(); 
        long num = Long.parseLong(p);
        for(int i=0; i<=t.length()-pSize; i++) {
            String part = t.substring(i, i+pSize);
            System.out.println(part);
            long number = Long.parseLong(part);
            if(number <= num) answer++;
        }

        return answer;
    }
}