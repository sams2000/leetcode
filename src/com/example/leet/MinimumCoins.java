package com.example.leet;

/**
 * Given a list of N coins, their values (V1, V2, ... , VN), 
 * and the total sum S. Find the minimum number of coins the 
 * sum of which is S (we can use as many coins of one type as we want), 
 * or report that it's not possible to select coins in such a way 
 * that they sum up to S. 
 * 
 *  Given coins with values 1, 3, and 5.
	The sum S is set to be 11.
	 
 * @author bin zhou
 * @since 2016-02-03
 */
public class MinimumCoins {
	public static void main(String[] args) {
		int[] values = new int[]{1, 3, 5};
		System.out.println("minimum coins: " + minimumCoins(values, 11));
	}
	
	/**
	 * classic DP solution
	 * @param values
	 * @param sum
	 * @return
	 */
	private static int minimumCoins(int[] values, int sum){
		if (sum ==0 ) return 0;
		
		int[] minCoins = new int[sum+1];
		minCoins[0]=0;
		for (int i = 1; i<=sum; i++) 
		    minCoins[i]=Integer.MAX_VALUE;
		
		for (int i=1; i<=sum; i++){
			for (int j=0; j<values.length; j++){
				if (values[j] == i){
					minCoins[i] = 1;
					continue;
				} else if (i - values[j] >0){//only compare positive remaining
					minCoins[i] = Math.min(minCoins[i-values[j]]+1, minCoins[i]);
				}
			}
		}
		
		return minCoins[sum];
	}

}


