'''
Sum Tree 
Given a Binary Tree. Check whether it is a Sum Tree or not.
A Binary Tree is a Sum Tree in which value of each node x is equal to sum of nodes present in its left subtree and 
right subtree . An empty tree is also a Sum Tree as sum of an empty tree can be considered to be 0. A leaf node is 
also considered as a Sum Tree.

Example 1:

Input:
    3
  /   \    
 1     2

Output: 1
Explanation: The given tree is a sum 
tree so return a boolean true.

'''

def sum(root):  #todo O(n^2)
    if root is None:
        return 0
    return root.data +sum(root.left)+sum(root.right)
    
def isSumTree(root):
    if root is None:
        return True
        
    if root.left is None and root.right is None:
        return True
    
    left = sum(root.left)
    right = sum(root.right)
    
    if root.data == left+right and isSumTree(root.left) and isSumTree(root.right):
        return True
        




'''
Same Tree or Identical tree
Given the roots of two binary trees p and q, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.


Example 1:
Input: p = [1,2,3], q = [1,2,3]
Output: true
'''

class Solution:
    def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
        if p is None and q is None:
            return True
        
        if p is None and q is not None:
            return False
        if p is not None and q is None:
            return False
        
        if p is not None and q is not None:
            if p.val == q.val and self.isSameTree(p.left,q.left) and self.isSameTree(p.right,q.right):
                return True




'''
Mirror Tree
For two trees ‘a’ and ‘b’ to be mirror images, the following three conditions must be true:

Their root node’s key must be same
Left subtree of root of ‘a’ and right subtree root of ‘b’ are mirror.
Right subtree of ‘a’ and left subtree of ‘b’ are mirror.

'''

def areMirror(root1,root2):
    if root1 is None and root2 is None:
        return True
    
    if root1 is None and root2 is not None:
        return False
    if root2 is None and root1 is not None:
        return False
    
    if root1 is not None and root2 is not None:
        if root1.data == root2.data and areMirror(root1.left,root2.right) and areMirror(root1.right and root2.left):
            return True


'''
Symmetric Tree
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
'''
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        return self.areMirror(root,root)
    
    
    def areMirror(self,root1,root2):
        if root1 is None and root2 is None:
            return True
        if root1 is None and root2 is not None:
            return False
        if root2 is None and root1 is not None:
            return False
        
        if root1 is not None and root2 is not None:
            if root1.val == root2.val and self.areMirror(root1.left,root2.right) and self.areMirror(root1.right,root2.left):
                return True
        

'''
Balanced Binary Tree
Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as:
a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: true
'''
class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        if root is None:
            return True
        
        if root.left is None and root.right is None:
            return True
        
        if abs(self.height(root.left)-self.height(root.right))<2 and self.isBalanced(root.left) and self.isBalanced(root.right):
            return True
        
    def height(self,root):
        if root is None:
            return 0
        
        return 1+max(self.height(root.left),self.height(root.right))

# O(n)
class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        return self.height(root)!=-1
    
    def height(self,root):
        if root is None:
            return 0
        
        left = self.height(root.left)
        right = self.height(root.right)
        
        if left==-1 or right==-1 or abs(left-right)>1:
            return -1
        
        return 1+max(left,right)

'''
Check Binary Search Tree
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:
Input: root = [2,1,3]
Output: true

'''

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        if root is None:
            return True
        
        return self.isBST(root,float('-inf'),float('inf') )
        
    def isBST(self,root,min,max):
        if root is None:
            return True
        
        if root.val<=min or root.val>=max:
            return False
        
        return self.isBST(root.left,min,root.val) and self.isBST(root.right,root.val,max)

        
'''
Check Completeness of a Binary Tree
Given the root of a binary tree, determine if it is a complete binary tree.
In a complete binary tree, every level, except possibly the last, is completely filled, and all nodes in the last 
level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.


Example 1:
Input: root = [1,2,3,4,5,6]
Output: true
Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}), and all nodes in the 
last level ({4, 5, 6}) are as far left as possible.
'''
import collections
class Solution:
    def isCompleteTree(self, root: TreeNode) -> bool:
        
        queue = collections.deque()
        queue.append((root,1))
        res = []
        
        while queue:
            node,nodeNo = queue.popleft()
            res.append(nodeNo)
            
            if node.left:
                queue.append((node.left,nodeNo*2))
            if node.right:
                queue.append((node.right,nodeNo*2+1))
                
        return len(res) == res[-1]

