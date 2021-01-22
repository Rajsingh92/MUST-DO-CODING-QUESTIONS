'''
Diagonal Traversal of Binary Tree 
Given a Binary Tree, print the diagonal traversal of the binary tree.
Consider lines of slope -1 passing between nodes. Given a Binary Tree, print all diagonal elements in a binary tree 
belonging to same line.

Example 1:

Input :
            8
         /     \
        3      10
      /   \      \
     1     6     14
         /   \   /
        4     7 13
Output : 8 10 14 3 6 7 13 1 4
'''

def diagonal_rec(root,diagonal,output):
    if root is None:
        return 
    
    output.setdefault(diagonal,[]).append(root.data)
    diagonal_rec(root.left,diagonal+1,output)
    diagonal_rec(root.right,diagonal,output)
    
def diagonal(root):
    if root is None:
        return []
        
    output = dict()
    
    diagonal_rec(root,0,output)
    
    final_res = []
    for key in sorted(output.keys()):
        for val in output[key]:
            final_res.append(val)
        
    return final_res


def diagonalprint(root): 
    if root is None: 
        return
    q = [] 
    q.append(root) 
    q.append(None)  # Append delimiter 
    output = []
  
    while len(q) > 0: 
        temp = q.pop(0) 
        if not temp: 
            if len(q) == 0: 
                return 
            q.append(None) 
  
        else: 
            while temp: 
                output.append(temp.data)
                if temp.left: 
                    q.append(temp.left) 
                temp = temp.right 

    return output

#DIAGONAL SUM