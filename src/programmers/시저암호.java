package programmers;

public class 시저암호 {
	public String solution(String s, int n) {
        
        char[] arr = s.toCharArray();
        
        for(int i=0; i<arr.length; i++) {
        	if(Character.isLowerCase(arr[i])) { // 97 ~122
        		int temp = (int) arr[i] + n;
        		if(temp > 122) {
        			temp = temp - 122;
        			temp += 96;
        		}
        		arr[i] = (char) temp;
        	}
        	
        	if(Character.isUpperCase(arr[i])) { // 97 ~122
        		int temp = (int) arr[i] + n;
        		if(temp > 90) {
        			temp = temp - 90;
        			temp += 64;
        		}
        		arr[i] = (char) temp;
        	}
        }
        return new String(arr);
    }
	
	public String solution2(String s , int n) {
		String result = "";
		n = n % 26;
		char[] arr = s.toCharArray();
		for(int i=0; i<arr.length; i++) {
			if (Character.isLowerCase(arr[i])) {
				arr[i] = (char) ((arr[i]-'a'+n) % 26 + 'a');
			}
			if(Character.isUpperCase(arr[i])) {
				arr[i] = (char) ((arr[i]-'A'+n) % 26 + 'A');
			}
		}
		return new String(arr);
	}
}
