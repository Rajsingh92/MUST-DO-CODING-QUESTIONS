'''
| 543 | Diameter of Binary Tree |  Easy | Adobe |
Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of 
the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
Note: The length of path between two nodes is represented by the number of edges between them.

'''

class Solution:
    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        if root is None:
            return 0
        
        #one left one right
        leftHeight = self.height(root.left)
        rightHeight = self.height(root.right)
        
        #both ends are at left
        leftDiameter = self.diameterOfBinaryTree(root.left)
        
        #both ends are at right
        rightDiameter = self.diameterOfBinaryTree(root.right)
        
        return max(leftHeight+rightHeight,max(leftDiameter,rightDiameter))
    
    def height(self,root):
        if root is None:
            return 0
        
        return 1+max(self.height(root.left),self.height(root.right))


# optimization
class Solution:
    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        if root is None:
            return 0 
        
        return self.getDiameter(root,0)[1]
        
    def getDiameter(self,root,diameter):
        if root is None:
            return 0,diameter
        
        leftHeight ,diameter = self.getDiameter(root.left,diameter)
        rightHeight ,diameter = self.getDiameter(root.right,diameter)
        
        max_diameter = leftHeight+rightHeight
        diameter = max(diameter,max_diameter)
        
        return max(leftHeight,rightHeight)+1,diameter