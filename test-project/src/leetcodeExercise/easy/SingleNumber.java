package leetcodeExercise.easy;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

	public static void main(String[] args) {
		int array[] = { 4, 1, 2, 1, 2 };
		int array2[] = { 2, 2, 1 };
		int singleNumber = singleNumber(array);
		System.out.println(singleNumber);

	}

	// pronadji element koji se nepojavljuje vise puta
	public static int singleNumber(int[] nums) {
		if(nums.length == 1)return nums[0];
		
		Map<Integer,Integer> map = new HashMap<>();
		
		for(int i=0;i<=nums.length-1;i++) {
			//dakle radi ovako
			/*
			 * Iteracija 1 
			 * DAJ mi za nums[i] koji je 4 njegovu vrednost posto je nema bice 0 i ovo plus 1 
			 * dakle {4=1} key je 4 value je 1 
			 * 
			 * pa za 1 odradi isto {1=1} isto i za {2=2}
			 * 
			 * e sad kad DODJE opet do 1 
			 * 
			 * videce da postoji samo sto ce na to sto postoji da ti doda 1 
			 * dakle {1=2}
			  // poenta je da ovde njegove values brojimo koliko njih ima u mapi
			 */
			map.put(nums[i],map.getOrDefault(nums[i], 0) + 1 );
		}
		
		for(int keys : map.keySet()) {
			//u prevodu ako u mapi postoji kljuc sa vrednostu 1 
			// vrati mi taj kljuc jer se on 1-put ponavlja
			if(map.get(keys) == 1) {
				return keys;
			}
		}
		return 0;
	}

}
