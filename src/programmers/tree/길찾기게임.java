package programmers.tree;

import java.util.ArrayList;
import java.util.List;

public class 길찾기게임 {
    
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
        return answer;
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
            preOrder(root.left);
            preOrder(root.right);
            result[0][index++] = root.index;
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
