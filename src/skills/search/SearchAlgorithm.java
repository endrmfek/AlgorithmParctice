package skills.search;

import java.util.List;

public class SearchAlgorithm {

    //정렬된 배열에서 k가 처음 등장한 위치 찾기
    public static int searchFirstOfK(List<Integer> A, int k) {
        int left = 0 , right = A.size()-1, result = -1;

        while(left <= right) {
            int mid = left + ((right-left) / 2);

            if(A.get(mid) > k) {
                right = mid-1;
            } else if(A.get(mid) == k) {
                //첫번째 A이기 때문에 내려가야될걸?
                result = mid;
                right = mid-1;
            } else {
                //k가 더 큰경우
                left = mid+1;
            }
        }
        return result;
    }

    //정렬된 배열에서 인덱스와 값이 같은 엔트리 찾기
    public static int searchEntryEqualToItsIndex(List<Integer> A) {
        int left = 0, right = A.size()-1;
        while(left <= right) {
            int mid = left + ((right - left) / 2);

            int difference = A.get(mid) - mid;
            if(difference == 0 ) return mid;
            else if(difference > 0) { // 값이 인덱스보다 크면 ex) a[4] = 6 -> 인덱스가 작아져야됨 == 값이 작아져야됨.
                right = mid-1;
            } else { // 값보다 인덱스가 크면? ex a[4] = 3 -> 값이 커져야됨 == 인덱스가 커져야됨.
                left = mid+1;
            }
        }
        return -1;
    }

    //환형으로 정렬된 배열에서 가장 작은 원소 탐색하기
    //Tip : 분할 정복?
    public static int searchSmallest(List<Integer> A) {
        int left = 0, right=A.size()-1;

        while(left < right) { // <= 가 아님.
            int mid = left + ((right - left)/2);

            //[m+1 , n-1] 범위에 무조건 존재해야됨.
            if(A.get(mid) > A.get(right)) {
                left = mid + 1;
            } else {
                //A[m] < A[n-1]면? -> 최소값은 없을걸? 그리고 중복된 원소가 없어서 A[m] <= A[n-1]일수도없어.
                //A.sublist(left, mid+1) 안에 있어.
                right = mid; // mid-1 이 아님.
            }

        }
        return left; // left == right 일때 종료.
    }

    //정수의 제곱근 구하기
    //제곱한 값이 주어진 정수보다 작거나같은 정수 중에서 가장 큰 정수를 찾는 프로그램.
    //Tip : 코너케이스
    public static int squareRoot(int k) {
        // x^2 > k 라면 x보다 큰 정수 답이 아니야.
        // x^2 < k 라면 x보다 작은 정수 답이 아니야.
        long left = 0, right =k;
        while(left <= right) {
            // 0 과 k 사이에서 적절한 수 찾아야돼.
            long mid = left + ((right - left) / 2);
            long midSquared = mid * mid;
            if(midSquared < k) {
                left = mid + 1;
            } else {
                right = mid-1;
            }
        }
        return (int) left - 1;
    }

    //정렬된 2차원 배열에서 탐색하기.
    //오른쪽 맨 위부터 시작하는게 포인트.
    public static boolean matrixSearch(List<List<Integer>> A , int x) {
        int row = 0, col = A.get(0).size()-1;
        while(row < A.size() && col >= 0) {
            if(A.get(row).get(col).equals(x)) {
                return true;
            } else if (A.get(row).get(col) < x) {
                ++row;
            } else {
                --col;
            }
        }
        return false;
    }

}
