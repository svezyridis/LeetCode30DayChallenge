/**
 * Say you have an array prices for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 * <p>
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 * <p>
 * Example 1:
 * <p>
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Example 2:
 * <p>
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 * engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= prices.length <= 3 * 10 ^ 4
 * 0 <= prices[i] <= 10 ^ 4
 */
public class Day5_BestTimeToBuyAndSellStockII {
    //beats 93.5%
    public class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 0 || prices.length == 1)
                return 0;
            if (prices.length == 2) {
                if (prices[1] > prices[0]) return prices[1] - prices[0];
                else return 0;

            }

            int possibleBuyDay = 0;
            int buyDay = 0;
            int sum = 0;
            boolean bought = false;
            for (int i = 1; i < prices.length; i++) {
                if (!bought && prices[i] > prices[possibleBuyDay]) {
                    bought = true;
                    buyDay = possibleBuyDay;
                }
                if (prices[i] < prices[i - 1]) {
                    if (bought) {
                        sum += prices[i - 1] - prices[buyDay];
                        possibleBuyDay = i;
                        bought = false;
                    } else
                        possibleBuyDay = i;
                }
            }
            if (bought) sum += prices[prices.length - 1] - prices[buyDay];
            return sum;
        }
    }
}
