//SLIDING WINDOW TECHNIQUE 

public class FindSmallestSubArray {
	//Find the smallest subarray with the given sum 
	//input = [4, 2, 4, 7, 8, 1, 2, 8, 1, 0]
	//smallest sum >= 8
	//find the smallest subarray in this array where the sum of the values are >= 8 (smallest value >= 8)
	public static int smallestSubarray(int targetSum, int[] arr) {
		
		int minWindowSize = Integer.MAX_VALUE;  //must always have max or min variable
		int currentSum = 0;
		int windowStart = 0;  //starting index
		for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			currentSum += arr[windowEnd];
			
			//once your greater than or equal to target sum, you need to see if you can do better,
			//find a lesser value than that --> shrink left hand size
			while(currentSum >= targetSum) {
				//add best number you're at into array
				minWindowSize = Math.min(minWindowSize, windowEnd - windowStart + 1);
				//remove value on far left (shrinking process)
				currentSum -= arr[windowStart];
				//increment it's location in array
				windowStart++;
			}
		}
		return minWindowSize;
	
	}
	
	public static void main(String[] args) {
		int[] input = new int[] {4,2,2,7,8,1,2,8,10};
		int targetSum = 8;  //smallest sum >= 8
		System.out.println(smallestSubarray(8, input));
		
		
	}


	
		
	}
	


