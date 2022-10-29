import java.util.*;
class Solution {
    public int solution(int distance, int[][] scope, int[][] times) {
            int answer = 0;
            boolean ox = false;
            Map<int[], int[]> data = new TreeMap<>((o1,o2)->o1[0]-o2[0]);
            for(int i=0; i< scope.length; i++) {
                data.put(scope[i], times[i]);
            }

            for(Map.Entry<int[], int[]> entry : data.entrySet()) {
                int[] scopeData = entry.getKey();
                int[] time = entry.getValue();

                int scopeStart = Math.min(scopeData[0], scopeData[1]);
                int scopeEnd = Math.max(scopeData[0], scopeData[1]);

                int work = time[0];
                int rest = time[1];

                int testTime = scopeStart;

                while(testTime <= scopeEnd) {
                    int test = testTime % (work + rest);

                    if(0 < test && test <= work) {
                        answer = testTime;
                        ox = true;
                        break;
                    }
                    testTime++;
                }
                if(ox) break;
            }

            if(ox) {
                return answer;
            } else {
                return distance;
            }
        }
}