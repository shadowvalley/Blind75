/***
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 * Best Time to Buy and Sell Stock
 */


class Solution {
    // TC -> O(n) where n = prices.length
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int max_profit = 0;

        while(right < prices.length) {
            if(prices[left] < prices[right]) {
                max_profit = Math.max(max_profit, prices[right] - prices[left]);
            } else {
                left = right;
            }
            right += 1;
        }

        return max_profit;
    }
}