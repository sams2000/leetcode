package com.example.leet;

/**
 * Say you have an array for which the i th element is the price of a given stock on day i.
 * @author bz250056
 * @since 2014-03-19
 * @since 2016-01-26
 * @since 2016-08-08
 */
public class BestTimeBuySellStock123 {

	public static void main(String[] args) {
		int[] input = {2,1,2,0,1};
		System.out.println(maxProfit1(input));
	}

	/**
	 * (I):  If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
	 * @param prices
	 * @return
	 */
    public static int maxProfit1(int[] prices) {
        if (prices.length<=1) return 0;
        
        int maxp = 0, minsofar=prices[0];
        for (int i=1; i<prices.length; i++){
            if (prices[i] > minsofar){
                maxp = Math.max(maxp, (prices[i] - minsofar));
            } else {
                minsofar = prices[i];
            }
            
        }
        
        return maxp;
    }
	
    
    /**
     * (II): Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        int maxp = 0;
        for (int i=1; i<prices.length; i++){
            if (prices[i] > prices[i-1]){
                maxp += prices[i] - prices[i-1];
            }
        }
        
        return maxp;
    }
    
    /**
     * (III) Design an algorithm to find the maximum profit. You may complete at most two transactions.
     * @param prices
     * @return
     */
	public static int maxProfit3(int[] prices) {
        int N = prices.length;
        if (N<=1) return 0;
        
        int[] forward = new int[N];
        int[] backward = new int[N];
        
        //process forward max profit for each day
        int minsofar = prices[0];
        for (int i=1; i<N; i++) {
            //record forward min stock price sofar
            if (prices[i] < minsofar){
                minsofar = prices[i];
                forward[i] =  forward[i-1];//carry forward
            } else {
                forward[i] = Math.max(forward[i-1], prices[i] - minsofar);
            }

        }
        
        //process backward max profit for each day
        int maxsofar = prices[N-1];
        for (int i=N-2; i>=0; i--) {
            //record backward max stock price sofar
            if (prices[i] > maxsofar){
                maxsofar = prices[i];   
                backward[i] = backward[i+1];//carry backward
            } else {
                backward[i] = Math.max(backward[i+1], maxsofar - prices[i]);
            }
        }        
        
        //process max profit of forward and backward combination in somewhere middle point
        int maxprofit = 0;
        for (int i=0; i<N; i++) {
            maxprofit = Math.max(maxprofit, forward[i] + backward[i]);
        }
        return maxprofit;
    }
}
