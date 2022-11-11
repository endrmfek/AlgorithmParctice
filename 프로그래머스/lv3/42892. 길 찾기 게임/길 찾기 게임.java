import java.util.ArrayList;
import java.util.List;

class Solution {
    //그래프 조옷같네
    //두팀으로 나누고 각 팀이 같은 곳을 다른 순서로 방문
    //먼저 순회 마친팀.
    //각 장소를 이진트리의 노드로
    //정수다
    //서로다른 x값
    //같은레벨의 노드는 같은 y
    //자식노드의 y는 항상 부모노드보다 작다.
    //왼쪽서브트리 x값은 작다
    //전위순회 : 루왼오
    //후위순회 : 오왼루
    int[][] result;
    int index;
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};
        List<node> tree = new ArrayList<>();
        for(int i=0; i< nodeinfo.length; i++) {
            tree.add(new node(i+1 , nodeinfo[i][0] , nodeinfo[i][1], null, null));
        }
        tree.sort((o1, o2) -> {
            if(o1.y == o2.y) {
                return o1.x-o2.x;
            }
            return o2.y - o1.y;
        });
        
        node root = tree.get(0);
        for(int i=1; i<tree.size(); i++) {
            insertNode(root, tree.get(i));
        }
        result = new int[2][nodeinfo.length];
        index = 0;
        preOrder(root);
        index = 0;
        postOrder(root);
        return result;
    }

    private void preOrder(node root) {
        if(root != null) {
            result[0][index++] = root.index;
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    private void postOrder(node root) {
        if(root != null) {
            postOrder(root.left);
            postOrder(root.right);
            result[1][index++] = root.index;
        }
    }

    private void insertNode(node parent, node child) {
        if(parent.x > child.x) {
            if(parent.left == null) parent.left = child;
            else insertNode(parent.left, child);
        } else {
            if(parent.right == null) parent.right = child;
            else insertNode(parent.right, child);
        }
    }
}

class node {
    int index;
    int x;
    int y;
    node left;
    node right;
    public node(int index, int x, int y, node left, node right) {
        this.index = index;
        this.x = x;
        this.y = y;
        this.left = left;
        this.right = right;
    }
}