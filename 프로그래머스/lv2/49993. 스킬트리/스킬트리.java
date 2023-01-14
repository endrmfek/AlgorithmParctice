import java.util.*;
class Solution {
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        List<Character> arr = new ArrayList<>();
        //만약 파이썬이었으면 skill


        //1<= skill <= 26
        for(int i=0; i<skill.length(); i++) {
            arr.add(skill.charAt(i));
        }

        //1 <= trees <= 20
        for (String skill_tree : skill_trees) {
            int skillIndex = -1;
            int flag = 0;
            for (int j = 0; j < skill_tree.length(); j++) {

                if(arr.contains(skill_tree.charAt(j))) { // 스킬에 포함되어 있으면
                    int index = arr.indexOf(skill_tree.charAt(j)); // 몇번째 스킬인지
//                    System.out.print(skill_tree.charAt(j) + ": "+ index) ;
                    if(skillIndex +1 == index) { // 맞는경우
                        skillIndex = index;
//                        System.out.print(skillIndex + " ");
                    } else {
                        flag = 1;
                        break;
                    }
                }

            }
//            System.out.println();
            if(flag == 0) {
                answer++;
            }

        }
        return answer;
    }
}