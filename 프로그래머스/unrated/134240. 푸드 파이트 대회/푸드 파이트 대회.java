class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<food.length; i++) {
            if (food[i] < 2) continue;

            for(int j=1; j<=food[i]/2; j++) {
                sb.append(i);
            }
        }
        
        StringBuilder sb2 = new StringBuilder(sb);
        sb.append(0).append(sb2.reverse());

        return sb.toString();
    }
}