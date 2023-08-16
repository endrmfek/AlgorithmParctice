# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        new_list = None
        current = head
        
        while current:
            #다음 노드를 저장
            next_node = current.next
            #앞으로 나올 노드들을 가장 앞으로
            current.next = new_list
            #new_list의 head를 맨앞으로 옮겨
            new_list = current
            #원래 리스트로 돌아와
            current = next_node
            
        return new_list
            