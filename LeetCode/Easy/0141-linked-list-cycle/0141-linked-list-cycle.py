# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:\
        
        #릿코드 진짜 이상해..
        if not head:
            return False
        
        cur = head
        slow = cur
        fast = cur.next
        
        #null check 잘해야돼.
        while fast and fast.next:
            
            if slow == fast:
                return True
            
            slow = slow.next
            fast = fast.next.next
            
        return False
        