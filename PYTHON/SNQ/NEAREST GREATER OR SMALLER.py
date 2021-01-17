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
 

#The Stock Span Problem       
def stock_span_problem(arr):
    stack = StackUsingArray()
    result = []

    for i in range(len(arr)):
        if stack.isEmpty():
            result.append(-1)
            stack.push([arr[i],i])
        elif not stack.isEmpty():
            while not stack.isEmpty() and arr[i]>stack.peek()[0]:
                stack.pop()
             
            if stack.isEmpty():
                result.append(-1)
            else:
                result.append(stack.peek()[1])

            stack.push([arr[i],i])

    output = []
    for index,element in enumerate(result):
        output.append(index-element)

    return output

#----------------------------------------------------------------------------------------------------------------------------------------------#
 

def maxAreaHistogram(arr):
    NSR = nearestSmallerToRight(arr)
    NSL = nearetSmallerToLeft(arr)

    width = []

    for i in range(len(arr)):
        width.append(NSR[i]-NSL[i]-1)
    
    area = []

    for i in range(len(arr)):
        area.append(arr[i]*width[i])

    return max(area)

#----------------------------------------------------------------------------------------------------------------------------------------------#