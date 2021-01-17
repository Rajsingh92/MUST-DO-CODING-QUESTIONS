'''
Binary Tree Preorder Traversal
Given the root of a binary tree, return the preorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [1,2,3]
'''

class Solution:
    def preorder(self,root,output):
        if root is None:
            return
        
        output.append(root.val)
        self.preorder(root.left,output)
        self.preorder(root.right,output)
        
    def preorderTraversal(self, root: TreeNode) -> List[int]:

        output = []
        self.preorder(root,output)
        return output
        
# Iterative Preorder Traversal
class Solution: 
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        if root is None:
            return []
        
        stack = [root]
        output = []
        
        while stack:
            node = stack.pop()
            output.append(node.val)
            
            if node.right:
                stack.append(node.right)
            if node.left:
                stack.append(node.left)
            

        return output
    
#morris traversal
class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:  
        curr = root
        output = []
        
        while curr:
            output.append(curr.val)
            #print(curr.val)
            
            if curr.left:
                temp = curr.left
                while temp.right is not None:
                    temp = temp.right
                temp.right = curr.right
                curr.right = None
                curr = curr.left
            else:
                curr = curr.right
                
        return output
                    
        
        