import java.util.*;
class Solution {
    public List<Long> solution(int n, long left, long right) {
        
        //1행 1열부터 i행i열까지 영역내의 모든 빈칸을 어떻게 채울꺼야?.. -> 여기서 오류. n의 범위가 너무큼.
        
        //공식이 있습니까?..
        List<Long> list = new ArrayList<>();
        for(long i=left; i<=right; i++) {
            //(행, 열) = i/n , i%n
        	list.add(Math.max(i/n, i%n) + 1);
        }
        
        return list;
    }
}