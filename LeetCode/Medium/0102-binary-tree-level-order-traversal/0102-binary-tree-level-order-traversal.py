from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        #bfs로 할 수 있다면?
        
        result = []
        if not root:
            return result
        
        q = deque()
        q.append(root)
        
        while q:    
            temp = []
            for size in range(len(q)):
                data = q.popleft()
                temp.append(data.val)

                if data.left:
                    q.append(data.left)

                if data.right:
                    q.append(data.right)
            result.append(temp)
            
        return result
            
                
            
            