package programmers;

public class 히샤드수 {
	public boolean solution(int x) {
        
        int num = 0;
        int number = x;
        while (x !=0) {
        	int remainder = x % 10;
        	x = x / 10;
        	num += remainder;
        }
        
        if( number % num != 0) {
        	return false;
        } else {
        	return true;
        }
        
        
    }
}
