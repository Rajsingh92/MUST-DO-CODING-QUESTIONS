/**
 * 

class Conversion: 
    def __init__(self, capacity): 
        self.top = -1 
        self.capacity = capacity 
        self.array = [] 
        self.output = [] 
        self.precedence = {'+':1, '-':1, '*':2, '/':2, '^':3} 
      
    def isEmpty(self): 
        return True if self.top == -1 else False
      
    def peek(self): 
        return self.array[-1] 
      
    def pop(self): 
        if not self.isEmpty(): 
            self.top -= 1
            return self.array.pop() 
        else: 
            return "$"
      
    def push(self, op): 
        self.top += 1
        self.array.append(op)  
  
    def isOperand(self, ch): 
        return ch.isalpha() 
  
    def notGreater(self, i): 
        try: 
            a = self.precedence[i] 
            b = self.precedence[self.peek()] 
            return True if a  <= b else False
        except KeyError:  
            return False
              
    def infixToPostfix(self, exp): 
        for i in exp: 
            if self.isOperand(i): 
                self.output.append(i) 
              
            elif i  == '(': 
                self.push(i) 
  
            elif i == ')': 
                while( (not self.isEmpty()) and 
                                self.peek() != '('): 
                    a = self.pop() 
                    self.output.append(a) 
                if (not self.isEmpty() and self.peek() != '('): 
                    return -1
                else: 
                    self.pop() 
            # An operator is encountered 
            else: 
                while(not self.isEmpty() and self.notGreater(i)): 
                    self.output.append(self.pop()) 
                self.push(i) 
  
        # pop all the operator from the stack 
        while not self.isEmpty(): 
            self.output.append(self.pop()) 
  
        print("".join(self.output)) 

    def isOperator(self,c):
        if c == "*" or c == "+" or c == "-" or c == "/" or c == "^" or c == "(" or c == ")":
            return True
        else:
            return False


    def prefixToInfix(self,exp):
        stack = []
        i = len(exp)-1
        while i>=0:
            if not self.isOperator(exp[i]):
                stack.append(exp[i])
                i-=1
            else:
                str = "(" + stack.pop() + exp[i] + stack.pop() + ")"
                stack.append(str)
                i -= 1

        return stack.pop()

    def evaluatePostfix(self, exp): 
        for i in exp: 
            if i.isdigit(): 
                self.push(i)  
            else: 
                val1 = self.pop() 
                val2 = self.pop() 
                self.push(str(eval(val2 + i + val1))) 
  
        return int(self.pop()) 

    def postToPre(self,exp):
        s = []
        length = len(exp)
        for i in range(length):
            if self.isOperator(exp[i]):
                op1 = s[-1]
                s.pop()
                op2 = s[-1]
                s.pop()

                tmp = exp[i]+op2+op1

                s.append(tmp)
            else:
                s.append(exp[i])

        ans = ''
        for i in s:
            ans+=i
        return ans

    def preToPost(self,exp):
        stack = []
        exp = exp[::-1]

        for i in exp:
            if self.isOperator(i):
                a = stack.pop()
                b = stack.pop()

                tmp =a+b+i
                stack.append(tmp)
            else:
                stack.append(i)

        return stack

    def postToInf(self,exp):  #incomplete
        s = []

        for i in exp:
            if self.isOperand(i):
                s.insert(0,i)
            else:
                op1 = s[0]
                s.pop(0)
                op2 = s[0]
                s.pop(0)

                s.insert(0,"("+op2+i+op1+")")

        return s[0]


    def infixToPre(self,exp):
        pass
 */