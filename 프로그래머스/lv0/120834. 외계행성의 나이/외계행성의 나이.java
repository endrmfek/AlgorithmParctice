class Solution {
    public String solution(int age) {
        //숫자 -> 영어
        String answer = String.valueOf(age);
        char[] numToChar = new char[] {'a','b','c','d','e','f','g','h','i','j'};
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<answer.length(); i++) {
            int num = answer.charAt(i) -'0';
            sb.append(numToChar[num]);
        }
        return sb.toString();
    }
}