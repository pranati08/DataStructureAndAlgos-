import java.util.*;
public class PermutationsInString {
	//satisfy 3 conditions:
	//1. length of original string and permutation string must be same
	//2. # of unique characters should be same
	//3. frequency of each unique character must be same
	
	//Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
	
	public static boolean checkInclusion(String s1, String s2) {
		//1. create hashmap
		//hashmap stores how many times each character occured 
		Map<Character, Integer> charCount = new HashMap<Character,Integer>();
		
		//2. populate hasmap with characters and frequency of each character in s2 string
		//use for each loop to get every character from the s2 string array
		for(char ch: s2.toCharArray()) {   //converts s2 string into sequence of characters
			//put character and its count in hashmap and get a value if the key is present or returns its default (0 or 2nd value)
			//getOrDefault optimizes code
			charCount.put(ch, charCount.getOrDefault(ch, 0)+ 1); //increment by 1 bc youre adding element to table 

				
			}
		int windowStart = 0;
		int matched = 0;
		//populate array like normal
		for(int windowEnd = 0; windowEnd < s1.length(); windowEnd++) {
			char left = s1.charAt(windowEnd);
			if(charCount.containsKey(left)) {
				//if matching character is found, subtract frequency of character from hashmap
				charCount.put(left, charCount.get(left) - 1);
				if(charCount.get(left) == 0) {   //if the frequency of a character is 0 then it's completley matched
												//2nd and 3rd conditions are satisfied 
					matched++;    //increment matched variable
				}
			}
			//if number of matched characters = number of unique characters in hashmap
			//1st condition is satisfied --> true 
			if(matched == charCount.size()) {
				return true;
			}
			if(windowEnd >= s2.length()-1) {
				char right = s1.charAt(windowStart++);
				if(charCount.containsKey(right)) {
					if(charCount.get(right)==0) {    //if frequence of right(starting) character is 0
						matched--;      //decrement matched count 
					}
					charCount.put(right, charCount.get(right)+1);   //update frequency count in hashmap
					//System.out.println(charCount.get(left));
				}
			}
			
		}
		return false;
		
	}
	public static void main(String args[]) {
		System.out.println(checkInclusion("eidbaooo", "ab"));
		
	}

}
