
'''
Binary Tree Paths
Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3

'''
class Solution:
    def binaryTreePaths(self, root: TreeNode) -> List[str]:
        if root is None:
            return []
        
        stack = []
        stack.append((root,str(root.val)))
        res = []
        
        while stack:
            node,path = stack.pop()
            
            if node.left is None and node.right is None:
                res.append(path)
            if node.left:
                stack.append((node.left,path+"->"+str(node.left.val)))
            if node.right:
                stack.append((node.right,path+"->"+str(node.right.val)))
                
                
        return (res)
        
        
        
        