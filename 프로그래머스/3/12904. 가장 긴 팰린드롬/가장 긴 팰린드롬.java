class Solution
{
    public int solution(String s) {
        
        char[] chars = s.toCharArray();
        for(int i=s.length(); i>0; i--) {
            for(int j=0; j+i<=s.length(); j++) {
                if(check(j, i+j-1, chars)) return i;
            }
        }
        return 0;
        
    }
    
    boolean check(int start, int end, char[] data) {
        while(start<end) {
            if(data[start++] != data[end--]) return false;
        }
        return true;
    }
    
}