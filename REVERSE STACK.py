def insertAtBottom(stack,item):
    if not stack:
        stack.append(item)
        return
    
    tmp = stack.pop()
    insertAtBottom(stack,item)
    stack.append(tmp)



def reverse(stack):
    if not stack:
        return

    top = stack.pop()
    reverse(stack)
    insertAtBottom(top)