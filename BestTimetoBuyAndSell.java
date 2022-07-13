//Best time to buy and sell stock
public class BestTimetoBuyAndSell {

	public static int maxProfit(int[] prices) {
		int minVal = Integer.MAX_VALUE;
		int maxProfit = 0;
		
		for(int i = 0; i < prices.length; i++ ) {
			//check if current i position is < current min?
			//if yes replcace current minimum
			
			if(prices[i] < minVal) {
				minVal = prices[i];
			} else if(prices[i] - minVal > maxProfit ){  //calculate profit at that position
				maxProfit = prices[i] - minVal;
			
				
			}
			
			
		}
		return maxProfit;
	}

}
