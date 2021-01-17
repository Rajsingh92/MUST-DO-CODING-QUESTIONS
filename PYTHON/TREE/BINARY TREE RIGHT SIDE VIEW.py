'''
Binary Tree Right Side View

Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you 
can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
'''

from collections import deque

class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        if root is None:
            return []
        
        queue = []
        queue.append(root)
        ans= []
        
        while queue:
            next_level = []
            count = len(queue)
            
            while count>0:
                count-=1
                node = queue.pop(0)
                
                if count == 0:
                    ans.append(node.val)
                    
                if node.left:
                    next_level.append(node.left)
                if node.right:
                    next_level.append(node.right)
                    
            queue = next_level
            
        return (ans)
            
        
        