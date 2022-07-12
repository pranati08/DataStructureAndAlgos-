//Given a string, find the length of the longest substring in it with no more 
//than K distinct characters.

//input = " a r a a c 9", k = 2
//there cannot be more than 2 of the same characters in a string

//SOLUTION:
//1. insert characters in beginning of string until we have enough k distinct in hashmap
//2. keep adding one character in window (slide window ahead) 
//3. shrink window at start if number of distinct characters is more than K. shrink window
	//until we have no more than K distinct characters in HashMap
//4. while shrinking decrement number of times character is going out the window and
	//remove from hashmap if its 0
import java.util.*;

public class LongestSubstring {
	public static int findLength(String s, int k) {
		//base case
		if(k == 0) return 0;
		
		//convert string to character array
		char[] arr = s.toCharArray();
		
		//define pointers
		int windowStart = 0;
		int maxValue = 0;
		
		//define table
		Map<Character, Integer> counter = new HashMap<Character, Integer>();
		
		//extend length of range
		for(int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
			
			//initialize right character pointer and add to array 
			char rightChar = s.charAt(windowEnd);
			
			//add current character into hashmap --> default is 0 and increment by 1 bc your adding element to table 
			counter.put(rightChar, counter.getOrDefault(rightChar, 0) + 1);
			
			//shrink sliding window if we dont meet the conditions,
			//until we are left with k distinct characters in hashmap
			//if size of map is bigger than k then shrink window until it gets to k length 
			while(counter.size() > k ) {
				char leftChar = s.charAt(windowStart);
				//remove elements on left side until we get to k length and put it in hashmap
				//we can use "get" and not "getOrDefault" bc we know that leftChar will be in window 
				 counter.put(leftChar, counter.get(leftChar) - 1);
				 if(counter.get(leftChar) == 0){
					counter.remove(leftChar);
					 
				 }
				 windowStart++;  //keep shrinking window(increment left pointer to right)
				
			}
			//update max length to what it is now
			maxValue = Math.max(maxValue, windowEnd - windowStart +1);  //computation to get max value
			
			
			
		}
		return maxValue;
		
		
		
	}
	
	public static void main(String args[]) {
		System.out.println("Lenght of longest substring: " + findLength("eceba", 2));
	}

}
