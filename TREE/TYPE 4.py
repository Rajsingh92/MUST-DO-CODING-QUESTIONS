'''
| 94 | Binary Tree Inorder Traversal |  Medium | Adobe, Google, Microsoft |
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


'''
| 144 | Binary Tree Preorder Traversal |  Medium | Google |
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
                    
        
'''
Vertical Order Traversal of a Binary Tree

Given a binary tree, return the vertical order traversal of its nodes values.
For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).
Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the 
values of the nodes in order from top to bottom (decreasing Y coordinates).
If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.
Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.

 
Example 1:
Input: [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation: 
Without loss of generality, we can assume the root node is at position (0, 0):
Then, the node with value 9 occurs at position (-1, -1);
The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
The node with value 20 occurs at position (1, -1);
The node with value 7 occurs at position (2, -2).
'''

from collections import deque
def verticalTraversal(root):
    if root is None:
        return
    
    queue = deque()
    queue.append((root,0))  # node + horizantal distance
    results = {}

    while queue:
        node,dist = queue.popleft()
        results.setdefault(dist,[]).append(node.data)

        if node.left:
            queue.append((node.left,dist-1))
        if node.right:
            queue.append((node.right,dist+1))

    #print result
    for key in sorted(results.keys()):
        print(results[key])

def preorderTraversal(root,dist,results):
    if root is None:
        return

    results.setdefault(dist,[]).append(root.data)
    preorderTraversal(root.left,dist-1,results)
    preorderTraversal(root.right,dist+1,results)

    

def verticalTraversal2(root):
    if root is None:
        return

    results  = {}
    
    preorderTraversal(root,0,results)

    for key in sorted(results.keys()):
        print(results[key])



# Vertical Sum In A Given Binary Tree

def verticalTraversalSum(root,dist,results):
    if root is None:
        return

    results[dist] = results.get(dist,0)+root.data
    preorderTraversal(root.left,dist-1,results)
    preorderTraversal(root.right,dist+1,results)
            
        
             
from collections import deque


def iterativePrePostInTraversal(root):   #1,2,3
    stack = deque()
    stack.append((root,1))
    preorder = inorder = postorder = ""

    while stack:
        node,state = stack.pop()

        if state == 1:  #preorder ,state++, left
            preorder = preorder+str(node)+""
            state +=1
            if node.left:
                stack.append((node.left,state))
        elif state == 2:  #inorder,state++,right
            inorder = inorder+str(node)+""
            state +=1
            if node.right:
                stack.append((node.right,state))
        elif state == 3: #postorder,pop
            postorder = postorder+str(node)
            stack.pop()
            
                       