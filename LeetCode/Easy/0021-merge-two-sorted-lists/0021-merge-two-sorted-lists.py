# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        #새로운 노드로 옮겨준다고 생각하면된다.
        head = ListNode()
        pointer = head
        
        while list1 and list2:
            
            if list1.val < list2.val:
                #list1의 노드값이 작으면
                #pointer를 list1의 노드를 가르켜
                pointer.next = list1
                #list1을 앞으로 옮겨
                list1 = list1.next
            else:
                pointer.next = list2
                list2 = list2.next
                
            pointer = pointer.next
                
        #남아있는 리스트
        pointer.next = list1 if list1 else list2
        
        #head를 반환하면 None까지 반환된다.
        return head.next