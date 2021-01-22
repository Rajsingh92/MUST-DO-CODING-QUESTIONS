class StackUsingArray:
    def __init__(self):
        self.stack = []
    
    def push(self,data):
        self.stack.append(data)
    
    def pop(self):
        if self.isEmpty():
            raise Exception('Stack Underflow')
        else:
            self.stack.pop()

    def peek(self):
        if self.isEmpty():
            return None
        return self.stack[-1]

    def isEmpty(self):
        return len(self.stack)==0

    def size(self):
        return len(self.stack)


def nearestGreaterToRight(arr):
    result = []
    stack = StackUsingArray()
    n = len(arr)

    for i in range(n-1,-1,-1):
        if stack.isEmpty():
            result.append(-1)
            stack.push(arr[i])
        else:
            #pop all smallest elemnt
            while not stack.isEmpty() and arr[i]>stack.peek():
                stack.pop()


            if stack.isEmpty():
                result.append(-1)
            else:
                result.append(stack.peek())

            stack.push(arr[i])

    result.reverse()
    return result


#----------------------------------------------------------------------------------------------------------------------------------------------#
 

def nearestSmallerToRight(arr):
    result = []
    stack = StackUsingArray()
    n = len(arr)

    for i in range(n-1,-1,-1):
        if stack.isEmpty():
            result.append(-1)
            stack.push(arr[i])
        else:
            #pop all smallest elemnt
            while not stack.isEmpty() and arr[i]<stack.peek():
                stack.pop()


            if stack.isEmpty():
                result.append(-1)
            else:
                result.append(stack.peek())

            stack.push(arr[i])

    result.reverse()
    return result

#----------------------------------------------------------------------------------------------------------------------------------------------#
 

def nearetSmallerToLeft(arr):
    result= []
    stack = StackUsingArray()

    for i in range(len(arr)):
        if stack.isEmpty():
            result.append(-1)
            stack.push(arr[i])
        else:
            while not stack.isEmpty() and arr[i]<stack.peek():
                stack.pop()

            if stack.isEmpty():
                result.append(-1)
            else:
                result.append(stack.peek())

            stack.push(arr[i])

    result.reverse()
    return result

#----------------------------------------------------------------------------------------------------------------------------------------------#
 
        
def nearetGreaterToLeft(arr):
    result = []
    stack = StackUsingArray()
    n = len(arr)

    for i in range(n-1,-1,-1):
        if stack.isEmpty():
            result.append(-1)
            stack.push(arr[i])
        else:
            #pop all smallest elemnt
            while not stack.isEmpty() and arr[i]>stack.peek():
                stack.pop()


            if stack.isEmpty():
                result.append(-1)
            else:
                result.append(stack.peek())

            stack.push(arr[i])

    result.reverse()
    return result

#----------------------------------------------------------------------------------------------------------------------------------------------#
