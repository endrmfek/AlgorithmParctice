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

    //N-Queen - 백트레킹 대표문제져
    public static List<List<Integer>> nQueens(int n) {
        List<List<Integer>> result = new ArrayList<>();
        solveNQueens(n, 0, new ArrayList<Integer>() , result);
        for(int i=0; i<result.size(); i++) {
            System.out.println(result.get(i).toString());
        }
        return result;
    }

    private static void solveNQueens(int n, int row, List<Integer> colPlacement, List<List<Integer>> result) {
        if(n == row) {
            result.add(new ArrayList<>(colPlacement));
            //리턴을 안하져?
        } else {
            for(int col = 0; col<n; col++) {
                colPlacement.add(col);
                if(isValid(colPlacement)) {
                    solveNQueens(n, row+1 , colPlacement, result);
                }
                colPlacement.remove(colPlacement.size()-1);
            }
        }
    }

    private static boolean isValid(List<Integer> colPlacement) {
        int rowID = colPlacement.size()-1;
        for(int i=0; i<rowID; i++) {
            int diff = Math.abs(colPlacement.get(i) - colPlacement.get(rowID));
            if(diff == 0 || diff == rowID - i) { // 같은 열이랑 같은 대각선은 안돼.
                return false;
            }
        }
        return true;
    }

    //순열 구하기
    //보통 visited를 사용하져 -> 썻던숫자 다시 안쓰려고
    //A[0]으로 시작하는 순열 나열하고
    //A[1]으로 시작하는 순열 나열하고..
    //A[1,n-1]순열 어떻게 구해?
    //a[1]으로시작하는 순열.. A[2, n-1]순열 나열해야지
    //A[1]으로 시작하는 순열 -> A[1]이랑 A[0]이랑 맞바꾼 뒤 A[1~n-1]계산.
    //ex) 7,3,5
    //7로 시작하는 순열 -> <3,5>의 모든 순열 나열. -> 3으로 시작하는 모든 순열 -> 5로 시작하는 모든순열 -> 하나뿐이지.
    //3이랑 5랑 맞바꿔서 순열 찾아봐. <5,3>에서 5로 시작하는 순열 -> 3으로 시작하는 모든 순열 -> 하나뿐
    //7로 시작하는 순열 -> <3,5> , <5,3>
    //7과 3을 맞바꿔서 찾아바. <7,5> , <5,7>..
    //코드로 이해해보자.
    public static List<List<Integer>> permutations(List<Integer> A) {
        List<List<Integer>> result = new ArrayList<>();
        directedPermutations(0,A,result);
//        for(List<Integer> list : result) {
//            System.out.println(list.toString());
//        }
        return result;
    }

    private static void directedPermutations(int i, List<Integer> a, List<List<Integer>> result) {
        if(i == a.size()-1) {
            result.add(new ArrayList<>(a));
            System.out.println();
            return;
        }
        for(int j=i; j<a.size(); j++) { // a[i]로 시작하는 모든 경우.
//            System.out.print("i = " + i + " j = " + j + " ");
            Collections.swap(a , i , j);
            //a.sublist(i+1 , A.size()) 계산해야됨.
            directedPermutations(i+1, a, result);
            Collections.swap(a, i, j);
        }
    }

    //멱집합 구하기
    public static List<List<Integer>> generatePowerSet(List<Integer> inputSet) {
        List<List<Integer>> powerSet = new ArrayList<>();
        directedPowerSet(inputSet, 0, new ArrayList<>(), powerSet);
        for(int i=0; i<powerSet.size(); i++) {
            System.out.println(powerSet.get(i).toString());
        }
        return powerSet;
    }

    private static void directedPowerSet(List<Integer> inputSet,
                                         int toBeSelected , List<Integer> selectedSoFar,
                                         List<List<Integer>> powerSet) {
        if (toBeSelected == inputSet.size()) {
            powerSet.add(new ArrayList<>(selectedSoFar));
            return;
        }

        //inputSet[toBeSelected]를 포함하는 모든 부분집합을 생성한다.
        selectedSoFar.add(inputSet.get(toBeSelected));
        directedPowerSet(inputSet, toBeSelected + 1, selectedSoFar, powerSet);
        //inputSet[toBeSelected]를 포함하지 않는 모든 부분 집합 생성
        selectedSoFar.remove(selectedSoFar.size() - 1);
        directedPowerSet(inputSet, toBeSelected + 1, selectedSoFar, powerSet);
    }

    //조합 구하기.
    public static List<List<Integer>> combination(int n , int k) {
        List<List<Integer>> result = new ArrayList<>();
        directedCombination(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    private static void directedCombination(int n, int k, int offset,
                                            List<Integer> partialCombination,
                                            List<List<Integer>> result) {
        // 4C2라면
        if(partialCombination.size() == k) {
            result.add(new ArrayList<>(partialCombination));
            return;
        }

        //집합 {offset, .. , n-1} 에서 크기가 numRemaining이 되는
        //남아 있는 조합을 생성한다.
        final int numRemaining = k - partialCombination.size();
        for(int i = offset; i<=n && numRemaining <= n-i+1; i++) {
            partialCombination.add(i);
            directedCombination(n, k, i+1, partialCombination, result);
            partialCombination.remove(partialCombination.size() - 1);
        }

    }

    public static void main(String[] args) {
        //nQueens(4);
        generatePowerSet(Arrays.asList(1,2,3,4));
    }


}
