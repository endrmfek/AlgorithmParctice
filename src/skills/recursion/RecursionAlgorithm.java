package skills.recursion;

import java.util.*;

public class RecursionAlgorithm {

    //최대공약수
    public static long GCD(long x, long y) {
        return y == 0 ? x : GCD(y, x%y);
    }

    //하노이 타워
    private static final int NUM_PAGE = 3;

    public static List<List<Integer>> computeTowerHanoi(int numRings) {
        List<Deque<Integer>> pegs = new ArrayList<>();
        for(int i=0; i<NUM_PAGE; i++) {
            pegs.add(new ArrayDeque<>());
        }

        for(int i=numRings; i>=1 ; i--) {
            pegs.get(0).addFirst(i);
        }
        List<List<Integer>> result = new ArrayList<>();
        computeTowerHanoiSteps(numRings, pegs, 0, 1, 2, result);
        return result;
    }

    private static void computeTowerHanoiSteps(int numRingsToMove,
                                               List<Deque<Integer>> pegs,
                                               int fromPeg,
                                               int toPeg,
                                               int usePeg,
                                               List<List<Integer>> result) {
        if(numRingsToMove > 0) {
            computeTowerHanoiSteps(numRingsToMove-1 , pegs, fromPeg, usePeg, toPeg, result);
            pegs.get(toPeg).addFirst(pegs.get(fromPeg).removeFirst());
            result.add(Arrays.asList(fromPeg,toPeg));
            computeTowerHanoiSteps(numRingsToMove-1, pegs, usePeg, toPeg, fromPeg, result);
        }

    }

}
