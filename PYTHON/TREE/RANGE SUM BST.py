'''
Range Sum of BST
Given the root node of a binary search tree, return the sum of values of all nodes with a value in the range 
[low, high].

Example 1:
Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
Output: 32

'''
class Solution:
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        
        if not root :
            return 0
        
        stack = [root]
        total = 0
        
        while stack:
            node = stack.pop()
            if low<=node.val<=high:
                total = total+node.val
                
                if node.left:
                    stack.append(node.left)
                if node.right:
                    stack.append(node.right)
            if node.val<low:
                if node.right:
                    stack.append(node.right)
            if node.val>high:
                if node.left:
                    stack.append(node.left)
                    
        return total
 
        
class Solution:
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        if root is None:
            return 0
        elif root.val>high:
            return self.rangeSumBST(root.left,low,high)
        elif root.val<low:
            return self.rangeSumBST(root.right,low,high)
        elif low<=root.val<=high:
            return root.val+self.rangeSumBST(root.left,low,high)+self.rangeSumBST(root.right,low,high)