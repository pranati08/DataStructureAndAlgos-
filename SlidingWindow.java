
public class SlidingWindow {
	//Find max sum subarray for fixed size K
	//[4, 2, 1, 7, 8, 1, 2, 8, 1, 0] --> find subsection in that array 
										//that gave largest value for size k 
	//window length = k
	//maximize window as we iterate through array
	//return maximum k value 

		
public static int findMaxSumSubarray(int[] arr, int k) {
	int maxValue = Integer.MIN_VALUE;   //needs to be intialized to really small value to start
	int currentSum = 0;
	
	//for loop to loop until you get to end of array 
	//grow window length to get it to have 3 elements in window 
	//i = index, shows how far you are in array
	for(int i = 0; i < arr.length; i++) {
		
		//add value to current sum
		currentSum += arr[i];
		
		//is currentSum > maxValue?
		if(i >= k - 1) {
			//index = 2 (3-1)--> means you have 3 elements in the list 
			//if you have 3 elements 
			//compare current sum to max value
			maxValue = Math.max(maxValue, currentSum);
			
			//next step --> subtract 4 and add 7 
			//current sum subtracts element from input array
			currentSum -= arr[i - (k - 1)]; //subtract furthest right value that violates the window size 3 criteria 
			
		}
	}
	

	
	return maxValue;
			
	
	
		}
		
public static void main(String args[]) {
	//prints max value
	System.out.println(findMaxSumSubarray(new int[] {4,2,1,7,8,1,2,8,1,0}, 3));
			
		}
	}



