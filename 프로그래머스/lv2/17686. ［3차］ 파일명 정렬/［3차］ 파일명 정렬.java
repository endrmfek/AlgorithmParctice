import java.util.*;
class Solution {
    //1. 파일명은 우선 HEAD 부분을 기준으로 사전 순으로 정렬한다.
    //2. NUMBER의 숫자 순으로 정렬한다. -> 앞에 0 무시.
    //3. 원래 입력에 주어진 순서 유지
    public static String[] solution(String[] files) {
        String[] answer = {};
        
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String head1 = returnHead(o1);
                String head2 = returnHead(o2);
                
                int number1 = returnNumber(o1);
                int number2 = returnNumber(o2);
                
                
                if(head1.equals(head2)) {
                    return number1-number2;
                }

                return head1.compareTo(head2);
            }
        });
        return files;
    }

    private static String returnHead(String file) {
        StringBuilder sb = new StringBuilder();

        //1. 확장자 빼버렷
        String fileName = file.split("\\.")[0];

        //2. HEAD, NUMBER 분리
        int firstNumberIndex = fileName.replaceFirst("\\d" , "*").indexOf("*");
        
        String head = fileName.substring(0, firstNumberIndex).toUpperCase();
        
        return head;
    }

    private static int returnNumber(String file) {
        StringBuilder sb = new StringBuilder();

        //1. 확장자 빼버렷
        String fileName = file.split("\\.")[0];

        //2. HEAD, NUMBER 분리
        int firstNumberIndex = fileName.replaceFirst("\\d" , "*").indexOf("*");
        for(int i=firstNumberIndex; i<fileName.length(); i++) {
            if(Character.isDigit(fileName.charAt(i))) {
                sb.append(fileName.charAt(i));
            } else {
                break;
            }
        }

        
        int number = Integer.parseInt(sb.toString());
        return number;
    }
}