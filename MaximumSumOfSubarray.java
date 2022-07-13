
public class MaximumSumOfSubarray {
	
public static void main(String[] args) {
	int[] arr = {2,1,5,1,3,2};  //input array
	int K = 3;
	System.out.println("Maximum Sum of subarray is: " + findMax(arr, K));
}

public static int findMax(int[] arr, int K) {
	//make windowsum, windowStart, and maxSum variables
	int windowSum = 0;
	int windowStart = 0;
	int maxSum = 0;
	
	//i pointer
	//start and end are both at 0
	//we need to increment end to value of k, make sure it is < length of array
	//increment end by 1 to include 
	for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
		windowSum = windowSum + arr[windowEnd]; //add the next element into array 
		
		if(windowEnd >= K - 1) {
			maxSum = Math.max(maxSum, windowSum);
			windowSum -= arr[windowStart]; // subtract the element going out
			windowStart++; // slide the window ahead
		}
	}
	
	return K;
	
}
}
