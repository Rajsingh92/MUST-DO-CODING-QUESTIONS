from collections import deque

class Stack:  # TWO QUEUE
    def __init__(self):
        self.queue1 = deque()
        self.queue2 = deque()

    # push operation costly
    def push1(self,x):
        if not self.queue1:
            self.queue1.append(x)
        else:
            while self.queue1:
                front = self.queue1.popleft()
                self.queue2.append(front)
            self.queue1.append(x)
            while self.queue2:
                front = self.queue2.popleft()
                self.queue1.append(front)

    def pop1(self):
        if not self.queue1:
            print("Stack Underflow")
        front = self.queue1.popleft()
        return front

    # pop operation costly
    def push2(self,x):
        self.queue1.append(x)
    
    def pop2(self):
        if not self.queue1:
            print("Stack underflow")
        
        while self.queue1:
            if len(self.queue1)==1:
                front = self.queue1.popleft
            else:
                self.queue2.append(self.queue1.popleft())
            
        while self.queue2:
            self.queue1.append(self.queue2.popleft())

        return front


class Stack:  # ONE QUEUE
    def __init__(self):
        self.queue = []

    def push(self,x):
        self.queue.append(x)

    def reverseQueue(self):
        if not self.queue:
            return

        front = self.queue.pop()
        self.reverseQueue()
        self.queue.append(front)

    def pop(self):
        if not self.queue:
            print("Stack Underflow")
            
        self.reverseQueue()
        fornt = self.queue.pop()
        self.reverseQueue()
        return fornt


