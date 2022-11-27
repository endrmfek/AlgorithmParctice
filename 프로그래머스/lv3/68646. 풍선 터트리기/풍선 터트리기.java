class Solution {
    //최후까지 남기는것이 가능한 풍선들의 개수.
    //번호가 더 작은 풍선을 터트리는 행위는 최대 1번.
    // [-16,27,65,-2,58,-92,-71,-68,-61,-33]	
    // -16, -92, -71, -68, -61, -33
    public int solution(int[] a) {
        //숫자가 3개있다고 생각하고 양쪽에 무슨수가 왔을때 살아남을 수 있는지 알면
        //전체적으로 공식이 완성이됨.
        int n = a.length;
        if(a.length == 1) {
            return 1;
        }
        int answer = 2; // 양쪽은 살 수 있거든.
        //기준으로 양쪽에 최소값을 찾아야돼.
        int min_value = Integer.MAX_VALUE;
        int[] left_min = new int[n];
        int[] right_min = new int[n];
        
        //왼쪽부터 해당 지점에서 최솟값
        for(int i=0; i<n; i++) {
            if(min_value > a[i]) {
                min_value = a[i];
            }
            left_min[i] = min_value;
        }
        min_value = Integer.MAX_VALUE;
        //오른쪽부터 해당 지점에서 최솟값
        for(int i=n-1;i>=0; i--) {
            if(min_value > a[i]) {
                min_value = a[i];
            }
            right_min[i] = min_value;
        }
        
        for(int i=1; i<n-1; i++) {
            if(a[i] > left_min[i-1] && a[i] > right_min[i+1]) {
                continue;
            }
            answer++;
        }
        return answer;
    }
}