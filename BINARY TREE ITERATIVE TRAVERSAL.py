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