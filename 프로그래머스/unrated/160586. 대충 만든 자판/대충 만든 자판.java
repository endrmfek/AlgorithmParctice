class Solution {
    //1. 만들 수 있는지 검사
    //2. 어떻게 최소로 만들수 있는지.
    public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        for(int i=0; i< targets.length; i++) {
            String target = targets[i]; //만들어야 하는 문자열
            int calc = 0; // 횟수
            boolean flag = false;
            for(int j=0; j<target.length(); j++) {
                char t = target.charAt(j); // target의 한 글자
                // System.out.print(t + " ");
                int index = 101;
                for(String key : keymap) { // key맵의 key를 돌아
                    if(key.indexOf(t) != -1) { //존재할때
                        if(index == -1) { //전에 -1였어?
                            index = key.indexOf(t);
                        } else {
                            index = Math.min(index, key.indexOf(t));
                        }
                    } else { // 존재하지 않아..
                        if(index == 101) { //첫번째 -1
                            index = key.indexOf(t);
                        } else if (index == -1){
                            index = key.indexOf(t);
                        }
                    }
                }
                // System.out.print(index + " ");
                if(index == -1) {
                    flag = true;
                    break;
                } else {
                    calc += index+1;
                }
            }
            // System.out.println();
            if(flag) {
                answer[i] = -1;
            } else {
                answer[i] = calc;    
            }
            
        }
        return answer;
    }
}