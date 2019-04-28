class Solution:
    def verifyPreorder(self, preorder):
        low, stack = float("-inf"), []
        for num in preorder:
	        # right tree node small than left
            if num < low: return False  
            while stack and num > stack[-1]:  
            # remove whole subtree left nodes
                low = stack.pop()
            stack.append(num)  
            # append tree nodes at same part
        return True