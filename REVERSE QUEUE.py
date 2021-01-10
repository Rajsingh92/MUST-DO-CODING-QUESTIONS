
def reverse(q):  #recursion
    if not q:
        return
    
    data = q.front()
    q.pop()
    reverse(q)
    q.enqueue(data)

def reverse2(q):  # stack

    stack = []
    while q:
        stack.append(q.popleft())
    while stack:
        q.append(stack.pop())