class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        int cardOneIdx = 0;
        int cardTwoIdx = 0;

        for(String g : goal) {
            if( cardOneIdx < cards1.length && g.equals(cards1[cardOneIdx])) {
                cardOneIdx++;
                continue;
            }

            if(cardTwoIdx < cards2.length && g.equals(cards2[cardTwoIdx])) {
                cardTwoIdx++;
                continue;
            }

            return "No";
        }

        return "Yes";
    }
}