class Solution:
    def getIntersectionNode(self, headA, headB):
        if not headA or not headB: return None
        pa, pb = headA, headB
        while pa is not pb:
            pa = headB if not pa else pa.next
            pb = headA if not pb else pb.next
        return pa  