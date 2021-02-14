//                  BUY AND SELL STOCK
//                  BUY AND SELL STOCK
//                  BUY AND SELL STOCK


/**
atmost 2 transaction
k transaction
with cooldown period
with transaction fees
 */





/**
Best Time to Buy and Sell Stock -- One transaction
| 121 | Best Time to Buy and Sell Stock |  Easy | Facebook |
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to 
sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 */

class Solution {
    public int maxProfit(int[] prices) {
        int lsf = Integer.MAX_VALUE;
        int profitToday = 0;
        int overallProfit = 0;
        
        for(int i = 0;i<prices.length;i++){
            if(prices[i]<lsf){
                lsf = prices[i];
            }
            
            profitToday = prices[i] - lsf;
            if(profitToday>overallProfit)
                overallProfit = profitToday;
        }
        
        return overallProfit;
    }
}


/**
Best Time to Buy and Sell Stock II -- Infinite transaction
| 122 | Best Time to Buy and Sell Stock II |  Easy | Alibaba |
Say you have an array prices for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell 
one share of the stock multiple times).
Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Example 1:

Input: [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 */

class Solution {
    public int maxProfit(int[] prices) {
        int buyDate  = 0;
        int sellDate = 0;
        int profit = 0;
        
        for(int i =1;i<prices.length;i++){
            if(prices[i]>=prices[i-1]){
                sellDate++;
            }else{
                profit += prices[sellDate] - prices[buyDate];
                sellDate = buyDate = i;
            }
        }
        profit += prices[sellDate] - prices[buyDate];  //last upstroke
        
        return profit;
    }
}

