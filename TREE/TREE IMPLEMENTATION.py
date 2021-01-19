# N-ARY TREE
class Solution:
    def maxDepth(self, root: 'Node') -> int:
        if root is None:
            return 0
        
        height = 0
        for child in root.children:
            height = max(height,self.maxDepth(child))
            
        return height+1 

class Solution:
    def __init__(self):
        self.arr = []
        
    def preorder(self, root: 'Node') -> List[int]:
        if root is None:
            return self.arr
        
        self.arr.append(root.val)
        
        for child in root.children:
            self.preorder(child)
        
        return self.arr

class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        if root is None:
            return []
        
        stack = [root]
        res = []
        
        while stack:
            node = stack.pop()
            res.append(node.val)
            
            for child in reversed(node.children):
                stack.append(child)
                
        return res









class Node:
    def __init__(self,data):
        self.data = data
        self.left = None
        self.right = None



def isLeaf(root):
    if root.left is None and root.right is None:
        return True
    return False

def countLeaf(root):
    if root is None:
        return 0
    if isLeaf(root):
        return 1

    return countLeaf(root.left)+countLeaf(root.right)

# Find min value in a BST
def minValue(root):
    if root is None:
        return 0

    curr = root
    while curr.left:
        curr = curr.left 

    return curr.data

# Find max value in a BST
def maxValue(root):
    if root is None:
        return 0

    curr = root
    while curr.right:
        curr = curr.right 

    return curr.data

# BST Search
def search(root,key):
    if root is None or root.data == key:
        return root
        
    if root.data<key:
        return search(root.right,key)

    return search(root.left,key)

def search2(root,key):
    if root is None:
        return False
    
    curr = root
    while curr:
        if curr.data == key:
            return True
        elif curr.data>key:
            curr = curr.left
        else:
            curr = curr.right
    return False

# BST Insert
def insert(root,key):
    if root is None:
        return Node(key) 

    if key<root.data:
        root.left = insert(root.left,key)   
    else:
        root.right = insert(root.right,key)
    
    return root

# BST Delete
def delete(root,key):
    if root is None:
        return root

    if root.data>key:
        root.left = delete(root.left,key)
    elif root.data<key:
        root.right = delete(root.right,key)
    else:
        if isLeaf(root):  #no child
            return None
        if root.left and root.right:  #two child
            predecessor = maxValue(root.left)
            root.data = predecessor.data
            root.left = delete(root.right,predecessor.data)
        else:  #one child
            child = root.left if root.left else root.right
            root = child
        
    return root


#BINARY TREE

def display(root):
    if root is None:
        return
    
    print(root.data,end=" ")
    display(root.left)
    display(root.right)

def size(root):
    if root is None:
        return 0 
    return 1+size(root.left)+size(root.right)

def height(root):
    if root is None:
        return 0
    return max(height(root.left),height(root.right))+1


def sum(root):
    if root is None:
        return 0
    return root.data+sum(root.left)+sum(root.right)

def maxOfTree(root):
    if root is None:
        return float('-inf')
    
    leftMax = maxOfTree(root.left)
    rightMax = maxOfTree(root.right)

    return max(root.data,leftMax,rightMax)


