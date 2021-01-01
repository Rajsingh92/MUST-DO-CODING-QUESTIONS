'''
Binary Tree Inorder Traversal
Given the root of a binary tree, return the inorder traversal of its nodes' values.


Example 1:
Input: root = [1,null,2,3]
Output: [1,3,2]
'''

class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        if root is None:
            return []
        
        output = []
        self.inorder(root,output)
        return output
    
    def inorder(self,root,output):
        if root is None :
            return 
        self.inorder(root.left,output)
        output.append(root.val)
        self.inorder(root.right,output)   

# iterative 
class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        stack = []
        output = []
        curr = root
        
        while curr or stack :
            while curr:
                stack.append(curr)
                curr = curr.left
            
            curr = stack.pop()
            output.append(curr.val)
            curr = curr.right
            
        return output

#morris traversal
class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        output = []
        curr = root
        
        while curr:
            if curr.left:
                temp  = curr.left
                leftPointer = curr.left
                while temp.right:
                    temp = temp.right
                temp.right = curr
                curr.left = None
                curr = leftPointer
            else:
                output.append(curr.val)
                curr = curr.right
                
        return output
