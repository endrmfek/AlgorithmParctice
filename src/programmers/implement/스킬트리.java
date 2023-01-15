package programmers.implement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class 스킬트리 {
    //"CBD" -> 선행되어야돼.
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        List<Character> arr = new ArrayList<>();

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
                    if(skillIndex +1 == index) { // 맞는경우
                        skillIndex = index;

                    } else {
                        flag = 1;
                        break;
                    }
                }

            }
            if(flag == 0) {
                answer++;
            }

        }
        return answer;
    }

    public static int solution2(String skill, String[] skill_trees) {
        int answer = 0;
        ArrayList<String> skillTrees = new ArrayList<String>(Arrays.asList(skill_trees));
        //ArrayList<String> skillTrees = new ArrayList<String>();
        Iterator<String> it = skillTrees.iterator();

        while (it.hasNext()) {
            //BCD를 제외한 문자 1개 -> replaceAll
            String s = it.next().replaceAll("[^" + skill + "]", "");
            System.out.println(s);
            if (skill.indexOf(s) != 0) {
                it.remove();
            }
        }
        answer = skillTrees.size();
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution2("CBD" , new String[] {"BACDE", "CBADF", "AECB", "BDA"}));
    }
}
