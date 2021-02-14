'''
Left View of Binary Tree 
Given a Binary Tree, print Left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from 
Left side. The task is to complete the function leftView(), which accepts root of the tree as argument.

Left view of following tree is 1 2 4 8.

          1
       /     \
     2        3
   /     \    /    \
  4     5   6    7
   \
     8   

'''

def leftView(root):
    if root is None:
        return

    queue = []
    queue.append(root)

    while  queue:
        i  = 0
        size = len(queue)

        while i<size:
            i+=1
            node = queue.pop(0)

            if i == 1:
                print(node.data,end=" ")
            if node.left :
                queue.append(node.left)
            if node.right:
                queue.append(node.right)