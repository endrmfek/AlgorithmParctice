# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution(object):
    
    def invertTree(self, root):
        # solution1
        # if not root:
        #     return None
        # root.left, root.right = self.invertTree(root.right), self.invertTree(root.left)
        # return root
    
        # solution2
        q = deque([root])
        while q:
            node = q.popleft()
            
            if node:
                node.left , node.right = node.right, node.left
                q.append(node.left)
                q.append(node.right)
                
        return root