'''
Online Stock Span
Write a class StockSpanner which collects daily price quotes for some stock, and returns the span of that stock's price for 
the current day.
The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going 
backwards) for which the price of the stock was less than or equal to today's price.
For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85], then the stock spans would be 
[1, 1, 1, 2, 1, 4, 6].

Example 1:

Input: ["StockSpanner","next","next","next","next","next","next","next"], [[],[100],[80],[60],[70],[60],[75],[85]]
Output: [null,1,1,1,2,1,4,6]

public static int[] solve(int[] arr) {
        int[] span = new int[arr.length];

        Stack < Integer > st = new Stack < > ();
        st.push(0);
        span[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            while (st.size() > 0 && arr[i] > arr[st.peek()]) {
                st.pop();
            }

            if (st.size() == 0) {
                span[i] = i + 1;
            } else {
                span[i] = i - st.peek();
            }

            st.push(i);
        }

        return span;
    }

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
'''

class StockSpanner:  #(INDICES-NGL)

    def __init__(self):
        self.stack = []

    def next(self, price: int) -> int:  #pair  (price,span)
        res = 1
        while self.stack and self.stack[-1][0]<=price:
            res+=self.stack.pop()[1]
        self.stack.append([price,res])
        return res
            