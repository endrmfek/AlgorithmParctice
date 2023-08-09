# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        #이건 다시 풀어봐야할거같은데.. 아무튼 잘 봐봐
        minValue, maxValue = min(p.val, q.val), max(p.val, q.val)
        
        while root:
            
            if minValue <= root.val <= maxValue:
                break;
            
            # 지금 값이 minValue보다 작어? -> 커져야지 -> right으로가
            if root.val < minValue:
                root = root.right
            elif root.val > maxValue:
                root = root.left
                
        return root