
import java.util.*;
public class Practice {
	public static int longestSubString(String s, int k) {
		//base case
		if( k== 0) return 0;  //if length does not exist, string is empty, return 0
		
		//convert string to character array
		char[] arr = s.toCharArray();  //this method converts string into sequence of characters and returns array of chars
		
		//initialize pointers 
		int windowStart = 0;
		int maxValue = 0;  //keeps track of length of substring and update if it is greater than current maxVal
		
		//define HashTable
		Map<Character, Integer> counter = new HashMap<Character, Integer>();
		
		//populate array--> extend length with k range 
		for(int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
			
			//initialize right character pointer and add to array
			char rightChar = s.charAt(windowEnd);
			
			//add char into hashmap --> default is 0 and increment by 1 bc youre adding characetr to hashmap
			counter.put(rightChar, counter.getOrDefault(rightChar,0) + 1);
			
			//shrink window from left side 
			//if size of map is bigger than k then shrink window until it gets to k length 
			while(counter.size()>k) {  //while size of hashmap is > 7
				char leftChar = s.charAt(windowStart);  //create left pointer and put at start of window
				//remove elements on left side until we get to k length and put it in hashmap
				//we can use "get" and not "getOrDefault" bc we know that leftChar will be in window 
				counter.put(leftChar, counter.get(leftChar - 1));
				 if(counter.get(leftChar) == 0){
						counter.remove(leftChar);
						 
				
			}
				 windowStart++; 
			
			
		}
			return maxValue = Math.max(maxValue, windowEnd - windowStart +1);
	}
		return maxValue;
		
		
	}
	
	public static void main(String args[]) {
		System.out.println()
		
	}
}
		