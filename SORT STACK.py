

def sortedInsert(stack,top):
    if not stack or top>stack[-1]:
        stack.append(top)
        return
    
    tmp = stack.pop()
    sortedInsert(stack,top)
    stack.append(tmp)
    

def sortStack(stack):
    if not stack:
        return
    
    top = stack.pop()
    sortStack(stack)
    sortedInsert(stack,top)

