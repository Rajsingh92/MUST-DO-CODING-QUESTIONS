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
            