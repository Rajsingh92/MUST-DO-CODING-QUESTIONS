'''
| 145 | Binary Tree Postorder Traversal |  Hard | Amazon |
Given the root of a binary tree, return the postorder traversal of its nodes' values.

 

Example 1:

Input: root = [1,null,2,3]
Output: [3,2,1]

'''


class Solution:
    def postorderTraversal(self, root: TreeNode) -> List[int]:
        if root is None:
            return []
        
        output = []
        self.postorder(root,output)
        return output
    
    def postorder(self,root,output):
        if root is None :
            return 
        
        self.postorder(root.left,output)
        self.postorder(root.right,output)        
        output.append(root.val)

# iterative
class Solution:
    def postorderTraversal(self, root: TreeNode) -> List[int]:
        if root is None:
            return []
        
        stack1 = [root]
        stack2 = []
        
        while stack1:
            node = stack1.pop()
            stack2.append(node.val)
            
            if node.left:
                stack1.append(node.left)
            if node.right:
                stack1.append(node.right)
        
        return stack2[::-1]

# Postorder traversal of Binary Tree without recursion and without stack
def postorder(head): 
    temp = head  
    visited = set() 
    while (temp and temp not in visited):  
          
        # Visited left subtree  
        if (temp.left and temp.left not in visited): 
            temp = temp.left  
              
        # Visited right subtree  
        elif (temp.right and temp.right not in visited): 
            temp = temp.right  
          
        # Print node  
        else: 
            print(temp.data, end = " ")  
            visited.add(temp)  
            temp = head