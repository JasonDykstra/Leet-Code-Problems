public class BestTimeToBuyAndSellStockII {

    //My solution:
    public int maxProfit(int[] prices) {
        //for this question, the solution is simple: there is no need to look at the profit for a larger range than
        //between two days. If you only add to your profit on days where you make money, you get the correct solution!

        int profit = 0;
        for (int i=0; i< prices.length-1; i++) {
            if (prices[i + 1] > prices[i]) profit += prices[i + 1] - prices[i];
        }

        return profit;
    }

    /*
    Runtime: 1 ms, faster than 91.19% of Java online submissions for Best Time to Buy and Sell Stock II.
    Memory Usage: 39.3 MB, less than 17.14% of Java online submissions for Best Time to Buy and Sell Stock II.
     */
}
