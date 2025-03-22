package leetcodeExercise.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SummaryRanges {

	public static void main(String[] args) {
		int nums[] = { 0, 1, 2, 4, 5, 7 };
		List<String> summaryNumbs = summaryRanges(nums);
		System.out.println(Arrays.toString(summaryNumbs.toArray()));
	}

	/*
	 * Uzastopni brojevi su oni gde je razlika izmeÄ‘u susednih brojeva taÄ�no 1.
	 * 
	 * PraktiÄ�no, samo traÅ¾imo gde se niz prekida i tu zavrÅ¡avamo opseg, pa
	 * nastavljamo novi.
	 * 
	 * Poenta je ovo zadatka je zapravo mnogo kretenska ti imas gore niz 0 , 1, 2, 4,5,7
	 * 
	 * dakle kada se vrti for petlja trazimo brojevi koji nisu uzastopni to znaci da 
	 * brojevi koji kada se broje 0,1,2, idu redom jedan za drugim nema zastoja
	 * a kada doddje do 4 tu je prekid jer iza 4 je 3 broj logicno prekinuo je brojanje 
	 * i samo treba da ispise u rezultatu da su brojevi od 0->2 UZASTOPNI i da je ok
	 * pa onda treba da kaze da su 4->5 UZASTOPNI 
	 * 
	 * i 7 na kraju da ispise poslednji broj to je sve
	 * 
	 * 2.) primer bi ti bio ovo
	 * [1, 2, 3, 4, 5, 100, 101, 102, 200]
		
		bilo bi ti u ovom formatu
		["1->5", "100->102", "200"]
		brojevi 1 do 5 uzastopni
		brojevi od 100 do 102 uzastopni
		i glupi 200
		
		
		0, 1, 2, 4, 5, 7 
	 * 
	 */
	public static List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<>();
		if (nums.length == 0)
			return result; // Ako je niz prazan

		int start = nums[0]; // PoÄ�etni broj opsega

		for (int i = 1; i <= nums.length; i++) {
			// Ako smo na kraju niza ili broj nije uzastopan
			if (i == nums.length || nums[i] != nums[i - 1] + 1) {
				// Ako je opseg samo jedan broj
				if (start == nums[i - 1]) {
					result.add(start + "");
				} else {
					result.add(start + "->" + nums[i - 1]);
				}
				// PoÄ�etak novog opsega
				if (i < nums.length) {
					start = nums[i];
				}
			}
		}
		return result;
	}
}
