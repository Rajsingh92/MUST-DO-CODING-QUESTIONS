

class TwoStack:
    def __init__(self,n):
        self.size = n
        self.stack = [None]*n
        self.top1 = -1
        self.top2 = self.size
    
    def push1(self,x):
        if self.top2-self.top1>1:
            self.top1+=1
            self.stack[self.top1] = x
        else:
            print("Stack Overflow")

    def push2(self,x):
        if self.top2-self.top1>1:
            self.top2-=1
            self.stack[self.top2] = x
        else:
            print("Stack Overflow")

    def pop1(self):
        if self.top1>=0:
            x = self.stack[self.top1]
            self.top1-=1
        else:
            print("Stack Underflow")

    def pop2(self):
        if self.top2<self.size:
            x = self.stack[self.top2]
            self.top2+=1
        else:
            print("Stack Underflow")


        